package jp.co.fnj.storage.api;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class MyBatisForUpdatePlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable table) {

		Field field = new Field("forUpdate", FullyQualifiedJavaType.getBooleanPrimitiveInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		context.getCommentGenerator().addFieldComment(field, table);
		topLevelClass.addField(field);

		Method getter = new Method("isForUpdate");
		getter.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
		getter.setVisibility(JavaVisibility.PUBLIC);
		getter.addBodyLine("return this.forUpdate;");
		context.getCommentGenerator().addGeneralMethodComment(getter, table);
		topLevelClass.addMethod(getter);

		Method setter = new Method("setForUpdate");
		setter.addParameter(new Parameter(FullyQualifiedJavaType.getBooleanPrimitiveInstance(), "forUpdate"));
		setter.addBodyLine("this.forUpdate = forUpdate;");
		setter.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(setter, table);
		topLevelClass.addMethod(setter);

		return true;
	}

	@Override
	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement xmlElement, IntrospectedTable table) {
		return sqlMapSelectByExampleGenerated(xmlElement, table);
	}

	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement xmlElement, IntrospectedTable table) {
		return sqlMapSelectByExampleGenerated(xmlElement, table);
	}

	private boolean sqlMapSelectByExampleGenerated(XmlElement xmlElement, IntrospectedTable table) {
		XmlElement element = new XmlElement("if");
		element.addAttribute(new Attribute("test", "forUpdate"));
		element.addElement(new TextElement("for update"));
		xmlElement.addElement(element);

		return true;
	}

}
