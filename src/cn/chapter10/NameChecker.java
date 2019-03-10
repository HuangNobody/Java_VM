/*
 * �����嵥10-12�� ���������NameChecker
 * ��������ϸ��Ĵ��벻��������METHOD,WARNING��û�ɸ������壬�������в��ˣ����ƣ���������
 */
package cn.chapter10;

import java.util.EnumSet;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner7;

/*
 * �������ƹ淶�ı����������<br>
 * ��������������͹淶���������һ����������WARNING��Ϣ
 */

/*
public class NameChecker {
	
	private final Messager messager;
	
	NameCheckScanner nameCheckScanner = new NameCheckScanner();
	
	NameChecker(ProcessingEnvironment processingEnv){
		this.messager = processingEnv.getMessager();
	}
	
	/*
	 * ��java�����������м�飬���ݡ�Java���Թ淶����3�棩��6.8�ڵ�Ҫ��Java��������Ӧ���������и�ʽ
	 * <u1>
	 * <li>���ӿڣ������շ�ʽ�����������ַ���д
	 * <li>�����������շ�ʽ�����������ַ�Сд
	 * <li>�ֶΣ�
	 * <u1>
	 * <li>�ࡢʵ�������������շ�ʽ�����������ַ�Сд
	 * <li>������Ҫ��ȫ����д
	 * </u1>
	 * </u1>
	 */
/*
	public void checkNames(Element element){
		nameCheckScanner.scan(element);
	}
	
	/*
	 * ���Ƽ����ʵ���࣬�̳���DJK1.7�����ṩ��ElementScanner7<br>
	 * ������Visitorģʽ���ʳ����﷨���е�Ԫ��
	 */
/*
	private class NameCheckScanner extends ElementScanner7<Void, Void>{
		//�˷������ڼ��Java��
		@Override
		public Void visitType(TypeElement e, Void p){
			scan(e.getTypeParameters(),p);
			checkCamelCase(e, true);
			super.visitType(e, p);
			return null;
		}
		
		//��鷽�������Ƿ�Ϸ�
		@Override
		public Void visitExecutable(ExecutableElement e, Void p){
			if(e.getKind() == METHOD){
				Name name = e.getSimpleName();
				if(name.contentEquals(e.getEnclosingElement().getSimpleName()))
					//messager.printMessage(WARNING, "һ����ͨ����"" + name + ""��Ӧ���������ظ��������빹�캯����������",e);
					messager.printMessage(WARNING, " һ����ͨ���� " + name + " ��Ӧ���������ظ��������빹�캯���������� ", e);
				
				checkCamelCase(e, false);
			}
			super.visitExecutable(e, p);
			return null;
		}
		
		//�����������Ƿ�Ϸ�
		@Override
		public Void visitVariable(VariableElement e, Void p){
			//������Variable��ö�ٻ������򰴴�д�������򣬷������շ�ʽ������������
			if(e.getKind() == ENUM_CONSTANT || e.getConstantValue() !=null || heuristicallyConstant(e))
				checkAllCaps(e);
			else
				checkCamelCase(e, false);
			return null;
		}

		//�ж�һ�������Ƿ��ǳ���
		private boolean heuristicallyConstant(VariableElement e) {
			if(e.getEnclosingElement().getKind() == INTERFACE)
				return true;
			else if(e.getKind() == FIELD &&e.getModifiers().containsAll(EnumSet.of(PUBLIC, STATIC, FINAL)))
				return true;
			else
				return false;
		}
		
		//��鴫���Element�Ƿ�����շ�ʽ����������������ϣ������������Ϣ
		public void checkCamelCase(Element e, boolean b) {
			String name = e.getSimpleName().toString();
			boolean previousUpper = false;
			boolean conventional =true;
			int firstCodePoint = name.codePointAt(0);
			
			if(Character.isUpperCase(firstCodePoint)){
				previousUpper = true;
				if(!initialCaps){
					messager.printMessage(WARNING, "����"+name+"Ӧ����Сд��ĸ��ͷ", e);
					return;
				}
			}else if(Character.isLowerCase(firstCodePoint)){
				if(initialCaps){
					messager.printMessage(WARNING, "����"+name+"Ӧ���Դ�д��ĸ��ͷ", e);
					return;
				}
			}else
				conventional = false;
			
			if(conventional){
				int cp = firstCodePoint;
				for(int i = Character.charCount(cp);i<name.length();i+=Character.charCount(cp)){
					cp = name.codePointAt(i);
					if(Character.isUpperCase(cp)){
						if(previousUpper){
							conventional = false;
							break;
						}
						previousUpper = true;
					}else
						previousUpper = false;
				}
			}
			
			if(!conventional)
				messager.printMessage(WARNING, "����"+name+"Ӧ�������շ�ʽ������(Camel case Names)", e);
		}
		
		//��д������飬Ҫ���һ����ĸ�����Ǵ�д��Ӣ����ĸ�����ಿ�ֿ������»��߻��д��ĸ
		private void checkAllCaps(Element e){
			String name = e.getSimpleName().toString();
			
			boolean conventional = true;
			int firstCodePoint = name.codePointAt(0);
			
			if(!Character.isUpperCase(firstCodePoint))
				conventional = false;
			else{
				boolean previousUnderscore = false;
				int cp = firstCodePoint;
				for(int i = Character.charCount(cp);i<name.length();i+=Character.charCount(cp)){
					cp = name.codePointAt(i);
					if(cp == (int)'_'){
						if(previousUnderscore){
							conventional = false;
							break;
						}
						previousUnderscore = true;
					}else{
						previousUnderscore = false;
						if(Character.isUpperCase(cp)&& !Character.isDigit(cp)){
							conventional = false;
							break;
						}
					}
				}
			}
			
			if(!conventional)
				messager.printMessage(WARNING, "����"+name+"Ӧ��ȫ���Դ�д��ĸ���»�����������������ĸ��ͷ", e);
			
		}
	}
}
*/
