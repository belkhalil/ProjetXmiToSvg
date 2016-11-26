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

import composant.Action;
public class ActionReader {
	//classe qui lit un fichier XMI et donne la liste des Actions
		Namespace uml=Namespace.getNamespace("http://schema.omg.org/spec/UML/2.0");
		Namespace xmi=Namespace.getNamespace("http://schema.omg.org/spec/XMI/2.1");		
		public List<Action> retournelistactions(String fichier) throws JDOMException, IOException{
			//list de retour
			List<Action> listAction=new ArrayList<Action>();
			//exploiter le jdom et prendre le fichier depuis la balise XMI
			SAXBuilder sxb=new SAXBuilder();
			Document document=sxb.build(new File(fichier));
			Element root=document.getRootElement();
			Element diagramxmi=root.getChild("Diagram",uml);		
			Element diagEltxmi=diagramxmi.getChild("Diagram.element",uml);
			List<Element> listElts=diagEltxmi.getChildren("DiagramElement",uml);
			Iterator<Element> passer=listElts.iterator();
			while(passer.hasNext()){
				Element courant=(Element)passer.next();
				if(courant.getAttributeValue("preferredShapeType").equals("ActivityAction")){
					Action action=new Action();
					//recuperer l'info id du xmi et l'affecter à l'objet swimlane
					action.setId(courant.getAttributeValue("subject").toString());
					//chaine de geometrie
					action.setGeometry(courant.getAttributeValue("geometry"));
					String geometry=courant.getAttributeValue("geometry");
					String chaine[]=null;
					for (int i=0;i <=3;i++){
						chaine=geometry.split(",", 4);
				      }
					action.setX(Integer.parseInt(chaine[0]));
					action.setY(Integer.parseInt(chaine[1]));
					action.setHeight(Integer.parseInt(chaine[2]));
				    action.setWidth(Integer.parseInt(chaine[3]));
					/*//ajouter les proprites
					String[] attributs=courant.getAttributeValue("geometry").split(","); 
					action.setHeight(Integer.parseInt(attributs[0]));
					action.setWidth(Integer.parseInt(attributs[1]));
					action.setHeight(Integer.parseInt(attributs[2]));
					action.setWidth(Integer.parseInt(attributs[3]));*/
					Element modelxmi=root.getChild("Model",uml);
					List<Element> modelMembers=modelxmi.getChildren("ownedMember");
					Iterator<Element> itername=modelMembers.iterator();
					while(itername.hasNext()){
						Element courantMember=(Element)itername.next();
						//if(courantMember.getAttributeValue("type",xmi).toString().equals("uml:Swimlane") && courantMember.getAttributeValue("id",xmi).toString().equals(id))
						if(courantMember.getAttributeValue("type",xmi).equals("uml:Action") && courantMember.getAttributeValue("id",xmi).equals(courant.getAttributeValue("subject")))
						action.setNom(courantMember.getAttributeValue("name"));
					}
					listAction.add(action);
				}
			}
			return listAction;
		}
		public static void main(String[] args) throws JDOMException, IOException {
			ActionReader red =new ActionReader();
			List<Action> listactions=red.retournelistactions("file.xmi");
			Iterator<Action> ati=listactions.iterator();
			while(ati.hasNext()){
				Action courant=(Action)ati.next();
				System.out.println("\nTitre acteur :"+courant.getNom());
				System.out.println("\nId element :"+courant.getId());
				System.out.println("\nX :"+courant.getX());
				System.out.println("\nY :"+courant.getY());}}}
						
			