package com;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import util.ActionReader;
import util.ControlFlowReader;
import util.FinalnodReader;
import util.IntialnodReader;
import util.SwimReader;
import composant.Action;
import composant.Controlflow;
import composant.Finalnod;
import composant.Initialnod;
import composant.Swimlane;

public class Pars {
	Namespace uml=Namespace.getNamespace("http://schema.omg.org/spec/UML/2.0");
	Namespace xmi=Namespace.getNamespace("http://schema.omg.org/spec/XMI/2.1");
	String name;
	String id;
	int largeur;
	int hauteur;
	
	List<Action> actions;
	List<Swimlane> swimlanes;
	List<Initialnod> initials;
	List<Finalnod> finals;
	List<Controlflow> controls;
	public Namespace getUml() {
		return uml;
	}
	public void setUml(Namespace uml) {
		this.uml = uml;
	}
	public Namespace getXmi() {
		return xmi;
	}
	public void setXmi(Namespace xmi) {
		this.xmi = xmi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public List<Swimlane> getSwimlanes() {
		return swimlanes;
	}
	public void setSwimlanes(List<Swimlane> swimlanes) {
		this.swimlanes = swimlanes;
	}
	public List<Initialnod> getInitials() {
		return initials;
	}
	public void setInitials(List<Initialnod> initials) {
		this.initials = initials;
	}
	public List<Finalnod> getFinals() {
		return finals;
	}
	public void setFinals(List<Finalnod> finals) {
		this.finals = finals;
	}
	public List<Controlflow> getControls() {
		return controls;
	}
	public void setControls(List<Controlflow> controls) {
		this.controls = controls;
	}
	public Pars(Namespace uml, Namespace xmi, String name, String id,
			int largeur, int hauteur, List<Action> actions,
			List<Swimlane> swimlanes, List<Initialnod> initials,
			List<Finalnod> finals, List<Controlflow> controls) {
		super();
		this.uml = uml;
		this.xmi = xmi;
		this.name = name;
		this.id = id;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.actions = actions;
		this.swimlanes = swimlanes;
		this.initials = initials;
		this.finals = finals;
		this.controls = controls;
	}
	public Pars() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  Pars retournDiagram(String fichier, Pars diag) throws JDOMException, IOException{
		 //On crée une instance de SAXBuilder
		SAXBuilder sxb=new SAXBuilder();
		// on crée un nouveau document JDOM avec en argument le fichier XMI 
		Document document=sxb.build(new File(fichier));
		//On initialise un nouvel élément racine avec l'élément racine du document.
		Element racine=document.getRootElement();
		Element diagramXMI=racine.getChild("Diagram",uml);
		diag.setName(diagramXMI.getAttributeValue("name"));
		diag.setId(diagramXMI.getAttributeValue("id",xmi));
		diag.setLargeur(Integer.parseInt(diagramXMI.getChild("Extension",xmi).getChild("properties").getChild("awidth").getAttributeValue("value").toString()));
		diag.setHauteur(Integer.parseInt(diagramXMI.getChild("Extension",xmi).getChild("properties").getChild("aheight").getAttributeValue("value").toString()));
		
		return diag;
	}
	public static void dessinerswim(Element svg, Swimlane swim){
		//on prend les information pour dessiner un swim et les affecter en svg 
		Element Rect= new Element("rect");
		Attribute hauteur=new Attribute("height",""+swim.getHieght());
		Attribute largeur=new Attribute("width",""+swim.getWidth());
		Attribute strok=new Attribute("stroke","black");
		Attribute strok_width=new Attribute("stroke-width","1");
		//les methode getter des color trouver dans la package awk.color rgb(color,color,color) 
		/*String filler="rgb("+couleurswim.getRed()+","+couleurswim.getGreen()+","+couleurswim.getBlue()+")";
		Attribute fill=new Attribute("fill",filler);*/
		
		Rect.setAttribute(hauteur);
		Rect.setAttribute(largeur);
		Rect.setAttribute(strok);
		Rect.setAttribute(strok_width);
		svg.addContent(Rect);
		
	}
	// pour dessiner action
	public static void dessinerAction(Action action, Element svg){
	Element Rect=new Element("rectangle");
	Attribute x=new Attribute("x",""+action.getX());
	Attribute y=new Attribute("y",""+action.getY());	
	Attribute hauteur=new Attribute("height",""+action.getHeight());
	Attribute largeur=new Attribute("width",""+action.getWidth());
	Attribute strok=new Attribute("stroke","black");
	Attribute strok_width=new Attribute("stroke-width","1");
		
		Rect.setAttribute(x);
		Rect.setAttribute(y);
		Rect.setAttribute(hauteur);
		Rect.setAttribute(largeur);
		Rect.setAttribute(strok);
		Rect.setAttribute(strok_width);
		//Rect.setAttribute(fill);
		svg.addContent(Rect);}
	//Dessiner inialnod
	public static void dessinerinitialnode(Initialnod nod, Element svg) {
		Element nd=new Element("cerle");
		Attribute cx=new Attribute("cx",""+nod.getCx());
		Attribute cy=new Attribute("cy",""+nod.getCy());
		Attribute stl=new Attribute("style","fill:lightblack;stroke:midnightblue;stroke-width:1");
		Attribute ry=new Attribute("ry",""+nod.getR());
		nd.setAttribute(cx);
		nd.setAttribute(cy);
		nd.setAttribute(ry);
		nd.setAttribute(stl);
		svg.addContent(nd);}
	//dessiner final nod
	public static void dessinerfinalnode(Finalnod nod, Element svg) {
		Element nd=new Element("cerle");
		Attribute cx=new Attribute("cx",""+nod.getCx());
		Attribute cy=new Attribute("cy",""+nod.getCy());
		Attribute stl=new Attribute("style","fill:none;stroke:midnightblue;stroke-width:1");
		Attribute ry=new Attribute("ry",""+nod.getR());
		nd.setAttribute(cx);
		nd.setAttribute(cy);
		nd.setAttribute(ry);
		nd.setAttribute(stl);
		svg.addContent(nd);
		Element ndi= new Element("cercle");
		int cxx =nod.getCx();
		int cyy =nod.getCy();
		int rr=nod.getR();
		Attribute cxi=new Attribute("cxi",""+(cxx-5));
		Attribute cyi=new Attribute("cyi",""+(cyy-5));
		Attribute ri=new Attribute("ri",""+(rr-5));
		Attribute stll=new Attribute("style","fill:lightblack;stroke:midnightblue;stroke-width:1");
		ndi.setAttribute(cxi);
		ndi.setAttribute(cyi);
		ndi.setAttribute(ri);
		ndi.setAttribute(stll);
		svg.addContent(ndi);
	}
	//dessiner ls associations 
	public static void dessinerControl(Controlflow courant1, Element svg){
							
			    Element line1=new Element("line");
			 	Attribute x1=new Attribute("x1",""+courant1.getX1());
			 	Attribute x2=new Attribute("x2",""+courant1.getX2());
			 	Attribute y1=new Attribute("y1",""+courant1.getY1());
				Attribute y2=new Attribute("y2",""+courant1.getY2());
				Attribute stroke=new Attribute("stroke","black");
				Attribute stroke_width=new Attribute("stroke-width","1");
				//Attribute fill=new Attribute("fill","white");
				line1.setAttribute(x1);
				line1.setAttribute(x2);
				line1.setAttribute(y1);
				line1.setAttribute(y2);
				line1.setAttribute(stroke);
				line1.setAttribute(stroke_width);
				//line1.setAttribute(fill);
				svg.addContent(line1);
			int ext1 =courant1.getX1();
			int ext2 =courant1.getX2();
			int eyt = courant1.getYe1();
			int eyt1 = courant1.getY1();
			int eyt2 =courant1.getY2();
			int h =0;
		    if((eyt-eyt1) > (eyt-eyt2))
			{
				
			    h=eyt2;
			}
		
			else 
			{
				
				 h=eyt1;
			}	
		
		   if(h==eyt1)
		   {
		     
			   
			Element  poly= new Element("polygon") ;
			Attribute stroke1=new Attribute("stroke","black");
			Attribute stroke_width1=new Attribute("stroke-width","2");
			Attribute fill1=new Attribute("fill","white");
		    Attribute point=new Attribute("points",""+ext1+","+h+" "+(ext1+6)+","+(h-12)+" "+(ext1-6)+","+(h-12)+" ");
			poly.setAttribute( stroke1);
			poly.setAttribute(stroke_width1);
			poly.setAttribute(fill1);
			poly.setAttribute(point);
			svg.addContent(poly);}}
					   

	public static void dessinerDiag(Pars diag, String fichier) throws FileNotFoundException, IOException{
		
		Element racine = new Element("html");
		Document document = new Document(racine);
		Element body = new Element("body");
		racine.addContent(body);
		Element svg=new Element("svg");
		Attribute width = new Attribute("width",""+diag.getLargeur());
		svg.setAttribute(width);
		Attribute height = new Attribute("height",""+diag.getHauteur());
		svg.setAttribute(height);
		body.addContent(svg);
		List<Swimlane> listswims=diag.getSwimlanes();
		Iterator<Swimlane> itu=listswims.iterator();
		while (itu.hasNext()){
			Swimlane courantswim=(Swimlane) itu.next();
			Pars.dessinerswim(svg,courantswim);
		}
		
		List<Action> listsactions=diag.getActions();
		Iterator<Action> it=listsactions.iterator();
		
		while(it.hasNext()){
			Action courantac=(Action) it.next();
			Pars.dessinerAction(courantac,svg);
	
		}
		
		List<Controlflow> listcntr=diag.getControls();
		Iterator<Controlflow> itassocs=listcntr.iterator();
		while(itassocs.hasNext()){
			Controlflow courantcontrl=(Controlflow)itassocs.next();
			Pars.dessinerControl(courantcontrl, svg);
		}
		
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		sortie.output(document, new FileOutputStream(fichier));	
	}
	public static void main(String[] args) throws  Throwable {
		// TODO Auto-generated method stub
        String fichier="file.xmi";
		ActionReader readact=new ActionReader();
		SwimReader readswim=new SwimReader();
		ControlFlowReader readcontrol=new ControlFlowReader();
		IntialnodReader readnodi = new  IntialnodReader();
		FinalnodReader readnodf=new FinalnodReader();
		Pars mondiagram=new Pars();
		Pars diag=mondiagram.retournDiagram(fichier,mondiagram);
		diag.actions=readact.retournelistactions(fichier);
		diag.swimlanes= readswim.retournelisswimlane(fichier);
		diag.controls=readcontrol.retournelisControlFlow(fichier);
		diag.initials=readnodi.retournintialnod(fichier);
		diag.finals=readnodf.retournelissfinod(fichier);
		String fichierdessin="C:/Users/Oùùm(Y)/Desktop/svg.html";
		Pars.dessinerDiag(diag,fichierdessin);
}}
