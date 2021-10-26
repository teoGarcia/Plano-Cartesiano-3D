package Control;

import Vista.Vista3D;
import Vista.VistaCoordenadas;
import Vista.VistaEjemploAngulos;
import Vista.VistaEjemploCoordenadas3D;
import Vista.VistaEjemploPunto;
import Vista.VistaEjemploSegmento;
import Vista.VistaEjemploSumaVectores;
import Vista.VistaEjemploVector;
import Vista.VistaEjemploVectorDePosicion;
import Vista.VistaInicioSesion;
import Vista.VistaMenu;
import Vista.VistaMenuEjemplos;
import Vista.VistaOlvidarContraseña;
import Vista.VistaPaletaColores;
import Vista.VistaPlanoCartesiano;
import Vista.VistaRegistrarUsuario;

public class ControlVistas {

	private VistaCoordenadas vc;private VistaRegistrarUsuario vru;private VistaPlanoCartesiano vpc;
	private VistaOlvidarContraseña voc;private VistaInicioSesion vis;private Vista3D v3d;
	private VistaMenu vm;private VistaMenuEjemplos vme;private VistaEjemploPunto vep;
	private VistaEjemploCoordenadas3D vec3D;private VistaEjemploSegmento ves;private VistaEjemploVector vev;
	private VistaEjemploVectorDePosicion vevp; private VistaEjemploSumaVectores vesv;
	private VistaEjemploAngulos vea;private VistaPaletaColores vpcolores;
	
	public ControlVistas(){
		
		setVis(new VistaInicioSesion(this));
		
		setVc(new VistaCoordenadas(this));
		
		setVru(new VistaRegistrarUsuario(this));
		
		setVpc(new VistaPlanoCartesiano(this));
		
		setVoc(new VistaOlvidarContraseña(this));
		
		setV3d(new Vista3D(this));
		
		setVm(new VistaMenu(this));
		
		setVme(new VistaMenuEjemplos(this));
		
		setVep(new VistaEjemploPunto(this));
		
		setVec3D(new VistaEjemploCoordenadas3D(this));
		
		setVes(new VistaEjemploSegmento(this));
		
		setVev(new VistaEjemploVector(this));
		
		setVevp(new VistaEjemploVectorDePosicion(this));
		
		setVesv(new VistaEjemploSumaVectores(this));
		
		setVea(new VistaEjemploAngulos(this));
		
		setVpcolores(new VistaPaletaColores(this));
	}


	public VistaCoordenadas getVc() {
		return vc;
	}


	public void setVc(VistaCoordenadas vc) {
		this.vc = vc;
	}

	public VistaRegistrarUsuario getVru() {
		return vru;
	}


	public void setVru(VistaRegistrarUsuario vru) {
		this.vru = vru;
	}


	public VistaPlanoCartesiano getVpc() {
		return vpc;
	}


	public void setVpc(VistaPlanoCartesiano vpc) {
		this.vpc = vpc;
	}


	public VistaOlvidarContraseña getVoc() {
		return voc;
	}


	public void setVoc(VistaOlvidarContraseña voc) {
		this.voc = voc;
	}


	public VistaInicioSesion getVis() {
		return vis;
	}


	public void setVis(VistaInicioSesion vis) {
		this.vis = vis;
	}


	public Vista3D getV3d() {
		return v3d;
	}


	public void setV3d(Vista3D v3d) {
		this.v3d = v3d;
	}


	public VistaMenu getVm() {
		return vm;
	}


	public void setVm(VistaMenu vm) {
		this.vm = vm;
	}


	public VistaMenuEjemplos getVme() {
		return vme;
	}


	public void setVme(VistaMenuEjemplos vme) {
		this.vme = vme;
	}


	public VistaEjemploPunto getVep() {
		return vep;
	}


	public void setVep(VistaEjemploPunto vep) {
		this.vep = vep;
	}


	public VistaEjemploCoordenadas3D getVec3D() {
		return vec3D;
	}


	public void setVec3D(VistaEjemploCoordenadas3D vec3d) {
		vec3D = vec3d;
	}


	public VistaEjemploSegmento getVes() {
		return ves;
	}


	public void setVes(VistaEjemploSegmento ves) {
		this.ves = ves;
	}


	public VistaEjemploVector getVev() {
		return vev;
	}


	public void setVev(VistaEjemploVector vev) {
		this.vev = vev;
	}


	public VistaEjemploVectorDePosicion getVevp() {
		return vevp;
	}


	public void setVevp(VistaEjemploVectorDePosicion vevp) {
		this.vevp = vevp;
	}


	public VistaEjemploSumaVectores getVesv() {
		return vesv;
	}


	public void setVesv(VistaEjemploSumaVectores vesv) {
		this.vesv = vesv;
	}


	public VistaEjemploAngulos getVea() {
		return vea;
	}


	public void setVea(VistaEjemploAngulos vea) {
		this.vea = vea;
	}


	public VistaPaletaColores getVpcolores() {
		return vpcolores;
	}


	public void setVpcolores(VistaPaletaColores vpcolores) {
		this.vpcolores = vpcolores;
	}
	
}
