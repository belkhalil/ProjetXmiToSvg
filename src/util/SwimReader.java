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
import composant.Swimlane;
public class SwimReader {
	//classe qui lit un fichier XMI et donne la liste des Swimlanes 
		Namespace uml=Namespace.getNamespace("http://schema.omg.org/spec/UML/2.0");
		Namespace xmi=Namespace.getNamespace("http://schema.omg.org/spec/XMI/2.1");		
		public List<Swimlane> retournelisswimlane(String fichier) throws JDOMException, IOException{
			//list de retour
			List<Swimlane> listswimlane=new ArrayList();
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
				if(courant.getAttributeValue("preferredShapeType").equals("ActivitySwimlane2")){
					Swimlane swim=new Swimlane();
					//recuperer l'info id du xmi et l'affecter à l'objet swimlane
					swim.setId(courant.getAttributeValue("subject").toString());
					//chaine de geometrie
					swim.setGeometry(courant.getAttributeValue("geometry").toString());
					//ajouter les proprites
					String[] attributs=courant.getAttributeValue("geometry").split(","); 
					swim.setHieght(Integer.parseInt(attributs[0]));
					swim.setWidth(Integer.parseInt(attributs[1]));
					//swim de swim
					Element modelxmi=root.getChild("Model",uml);
					List<Element> modelMembers=modelxmi.getChildren("ownedMember");
					Iterator<Element> itername=modelMembers.iterator();
					while(itername.hasNext()){
						Element courantMember=(Element) itername.next();
						//if(courantMember.getAttributeValue("type",xmi).toString().equals("uml:Swimlane") && courantMember.getAttributeValue("id",xmi).toString().equals(id))
						if(courantMember.getAttributeValue("type",xmi).toString().equals("uml:Swimlane") && courantMember.getAttributeValue("id",xmi).toString().equals(courant.getAttributeValue("subject").toString()))
						swim.setNom(courantMember.getAttributeValue("name").toString());
					}
					listswimlane.add(swim);
				}
			}

			
			
			return listswimlane;
		}

}
