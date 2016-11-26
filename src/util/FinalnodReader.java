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
import composant.Finalnod;
	public class FinalnodReader {
		//classe qui lit un fichier XMI et donne la liste des Swimlanes 
			Namespace uml=Namespace.getNamespace("http://schema.omg.org/spec/UML/2.0");
			Namespace xmi=Namespace.getNamespace("http://schema.omg.org/spec/XMI/2.1");		
			public List<Finalnod> retournelissfinod(String fichier) throws JDOMException, IOException{
				//list de retour
				List<Finalnod> listfinalnod=new ArrayList();
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
					if(courant.getAttributeValue("preferredShapeType").equals("ActivityFinalNode")){
						Finalnod fininod=new Finalnod();
						//recuperer l'info id du xmi et l'affecter à l'objet initianode
						fininod.setId(courant.getAttributeValue("subject").toString());
						//chaine de geometrie
						fininod.setGeometry(courant.getAttributeValue("geometry").toString());
						//ajouter les proprites
						String[] attributs=courant.getAttributeValue("geometry").split(","); 
						fininod.setCx(Integer.parseInt(attributs[0]));
						fininod.setCy(Integer.parseInt(attributs[1]));
						fininod.setR(Integer.parseInt(attributs[2]));
							
						listfinalnod.add(fininod);
					}
				}
				return listfinalnod;
			}

	}

