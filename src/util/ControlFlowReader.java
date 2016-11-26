package util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import composant.Controlflow;
public class ControlFlowReader {
	//classe qui lit un fichier XMI et donne la liste des Actions
		Namespace uml=Namespace.getNamespace("http://schema.omg.org/spec/UML/2.0");
		Namespace xmi=Namespace.getNamespace("http://schema.omg.org/spec/XMI/2.1");		
		public List<Controlflow> retournelisControlFlow(String fichier) throws JDOMException, IOException{
			//list de retour
			List<Controlflow> listControlFlow=new ArrayList<Controlflow>();
			//exploiter le jdom et prendre le fichier depuis la balise XMI
			SAXBuilder sxb=new SAXBuilder();
			Document document=sxb.build(new File(fichier));
			Element root=document.getRootElement();
			Element diagramxmi=root.getChild("Diagram",uml);		
			Element diagEltxmi=diagramxmi.getChild("Diagram.element",uml);
			List<Element> listElts=diagEltxmi.getChildren("DiagramElement",uml);
			Iterator<Element> passer=listElts.iterator();
			while(passer.hasNext()){
			
				
				
				
				
				
				
				Element courant=(Element) passer.next();
				if(courant.getAttributeValue("preferredShapeType").equals("ControlFlow")){
				Controlflow contrlFlow=new Controlflow();
					//recuperer l'info id du xmi et l'affecter à l'objet swimlane
				contrlFlow.setId(courant.getAttributeValue("subject").toString());
					//chaine de geometrie
				contrlFlow.setGeometry(courant.getAttributeValue("geometry").toString());
				String geometry=courant.getAttributeValue("geometry");
				String attributs[]=null;
					//ajouter les proprites
				for (int i=0;i <=3;i++){
					attributs=geometry.split(",", 4);
			      }
					
					contrlFlow.setX1(Integer.parseInt(attributs[0]));
					contrlFlow.setY1(Integer.parseInt(attributs[1]));
					contrlFlow.setX2(Integer.parseInt(attributs[2]));
					contrlFlow.setY2(Integer.parseInt(attributs[3]));
					/*Element modelxmi=root.getChild("Model",uml);
					List<Element> modelMembers=modelxmi.getChildren("ownedMember");
					Iterator<Element> itername=modelMembers.iterator();
					while(itername.hasNext()){
						Element courantMember=(Element) itername.next();
						//if(courantMember.getAttributeValue("type",xmi).toString().equals("uml:Swimlane") && courantMember.getAttributeValue("id",xmi).toString().equals(id))
						if(courantMember.getAttributeValue("type",xmi).toString().equals("uml:Action") && courantMember.getAttributeValue("id",xmi).toString().equals(courant.getAttributeValue("subject").toString()))
						contrlFlow.setNom(courantMember.getAttributeValue("name").toString());}*/
					listControlFlow.add(contrlFlow);
				}
			}

			
			
			return listControlFlow;
		}

}
