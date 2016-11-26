package com;


import java.io.IOException;
import org.jdom2.JDOMException;
import util.ActionReader;
import util.ControlFlowReader;
import util.FinalnodReader;
import util.IntialnodReader;
import util.SwimReader;

public class Tset {

	public static void main(String[] args) throws JDOMException, IOException {
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
		String fichierdessin="C:/Users/user/Desktop/svg.html";
		Pars.dessinerDiag(diag,fichierdessin);

	}

}
