/*
 * �����嵥10-11�� ע�⴦����NameCheckProcessor
 */
package cn.chapter10;


import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

//�����á�*����ʾ֧�����е�Annotations
//@SupportedAnnotationTypes("*")

//ֻ֧��JDK1.6��Java����(�ҵ���jdk1.7�������Ұ�����SourceVersion.RELEASE_6��ΪSourceVersion.RELEASE_7)
//@SupportedSourceVersion(SourceVersion.RELEASE_7)
/*
public class NameCheckProcessor extends AbstractProcessor{

	private NameChecker nameChecker;
	
	//��ʼ�����Ƽ����
	@Override
	public void init(ProcessingEnvironment processingEnv){
		super.init(processingEnv);
		nameChecker = new NameChecker(processingEnv);
	}
	
	//��������﷨���ĸ����ڵ�������Ƽ��
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv){
		if(!roundEnv.processingOver()){
			for(Element element : roundEnv.getRootElements())
				nameChecker.checkNames(element);
		}
		return false;
	}
}
*/
