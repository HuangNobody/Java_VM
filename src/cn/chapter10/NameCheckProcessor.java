/*
 * 代码清单10-11， 注解处理器NameCheckProcessor
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

//可以用“*”表示支持所有的Annotations
//@SupportedAnnotationTypes("*")

//只支持JDK1.6的Java代码(我的是jdk1.7，所以我把书中SourceVersion.RELEASE_6改为SourceVersion.RELEASE_7)
//@SupportedSourceVersion(SourceVersion.RELEASE_7)
/*
public class NameCheckProcessor extends AbstractProcessor{

	private NameChecker nameChecker;
	
	//初始化名称检查插件
	@Override
	public void init(ProcessingEnvironment processingEnv){
		super.init(processingEnv);
		nameChecker = new NameChecker(processingEnv);
	}
	
	//对输入的语法树的各个节点进行名称检查
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
