package logico;

import java.util.ArrayList;



public class Clinica {
	
	private ArrayList<Paciente> misPacientes;
	private ArrayList<Medico> misMedicos;
	private ArrayList<Cita> misCitas;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Enfermedad> misEnfermedades;
	/*private int cant = 0;
	private int cantmax = 0;
	private String tipo;
	private String tipomax;*/
	public static int codigo = 1;
	public static int consultaCodigo = 1;
	private static Clinica clinic = null;

	public static String pacienteCedula = "";
	public static String medicoCedula = "";
	
	
	public static Clinica getInstance() {
		if(clinic==null)
			clinic = new Clinica();
		return clinic;
		
	}

	
	public Clinica() {
		super();
		this.misPacientes = new ArrayList<Paciente>();
		this.misMedicos = new ArrayList<Medico>();
		this.misConsultas = new ArrayList<Consulta>();
		this.misCitas = new ArrayList<Cita>();
		this.misEnfermedades = new ArrayList<Enfermedad>();
		this.misVacunas = new ArrayList<Vacuna>();
	}
	

	
	public ArrayList<Paciente> getMisPacientes() {
		return misPacientes;
	}

	public void setMisPacientes(ArrayList<Paciente> misPacientes) {
		this.misPacientes = misPacientes;
	}

	public ArrayList<Medico> getMisMedicos() {
		return misMedicos;
	}

	public void setMisMedicos(ArrayList<Medico> misMedis) {
		this.misMedicos = misMedis;
	}
	
	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}


	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}

	public void modificarPaciente(Paciente miPaciente) {
		int index = buscarIndexPacByCode(miPaciente.getCedula());
		misPacientes.set(index, miPaciente);
	}
	
	public void modiMed(Medico misMedis) {
		int cont = buscarIndexMedByCode(misMedis.getCedula());
		misMedicos.set(cont, misMedis);
	}

	public Paciente buscarPaciente(String idPaciente) {
		Paciente temp = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misPacientes.size()) {
			if(misPacientes.get(i).getCedula().equalsIgnoreCase(idPaciente)){
				temp = misPacientes.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return temp;
	}
	

	public int cantPacientes(int seleccion) {
		int cant = 0;
		
		for(Paciente aux : misPacientes) {
			switch(seleccion) {
			case 0:
				cant++;
				break;
			case 1:
				if(aux.isEstado() == false)
					cant++;
				break;
			case 2:
				if(aux.isEstado() == true)
					cant++;
				break;
			case 3:
				if(aux.getSexo() == 'H')
					cant++;
				break;
			case 4: 
				if(aux.getSexo() == 'M')
					cant++;
				break;
			default: 
				break;
			}
		}
		
		return cant;
	}

	
	
	public Medico buscarMedico(String cedu) {
		Medico temp = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misMedicos.size()) {
			if(misMedicos.get(i).getCedula().equalsIgnoreCase(cedu)){
				temp = misMedicos.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return temp;
	}
	
	public Enfermedad buscarEnfermedad(String idEnfermedad) {
		Enfermedad temp = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misEnfermedades.size()) {
			if(misEnfermedades.get(i).getId().equalsIgnoreCase(idEnfermedad)){
				temp = (Enfermedad) misEnfermedades.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return temp;
	}
	
	public Consulta buscarConsulta(String idConsulta) {
		Consulta temp = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misConsultas.size()) {
			if(misConsultas.get(i).getCodigo().equalsIgnoreCase(idConsulta)){
				temp =  misConsultas.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return temp;
	}
	
	public Vacuna buscarVacuna(String idVacuna) {
		Vacuna temp = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misVacunas.size()) {
			if(misVacunas.get(i).getCodigo().equalsIgnoreCase(idVacuna)){
				temp =  misVacunas.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return temp;
	}
	
	private int buscarIndexPacByCode(String codigo) {
		int aux = -1;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misPacientes.size()) {
			if(misPacientes.get(i).getCedula().equalsIgnoreCase(codigo)){
				aux = i;
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	private int buscarIndexMedByCode(String cedu) {
		int aux = -1;
		boolean encontrado = false;
		int i=0;
		while (i<misMedicos.size()&& !encontrado) {
			if(misMedicos.get(i).getCedula().equalsIgnoreCase(cedu)){
				encontrado = true;
				aux = i;
			}
			i++;
		}
		
		return aux;
	}
	
	private int buscarIndexVacByCode(String code) {
		int aux = -1;
		boolean encontrado = false;
		int i=0;
		while (i<misVacunas.size()&& !encontrado) {
			if(misVacunas.get(i).getCodigo().equalsIgnoreCase(code)){
				encontrado = true;
				aux = i;
			}
			i++;
		}
		
		return aux;
	}
	

	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}


	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}

/*
	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}


	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}

	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}


	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}


	
*/
	
	public void insertarPaciente(Paciente miPaciente) {
		misPacientes.add(miPaciente);
	}
	
	public void insertarMedico(Medico misMedis) {
		misMedicos.add(misMedis);
	}
	
	
	public void eliminarMedico(Medico select) {
		int cont;
		cont = misMedicos.indexOf(select);
		misMedicos.remove(cont);
	}
	
	
	public void insertarVacuna(Vacuna misVacs) {
		misVacunas.add(misVacs);
		codigo++;
	}

	public void insertarEnfermedad(Enfermedad miEnfermedad) {
		misEnfermedades.add(miEnfermedad);
	}
	
	public void insertarConsulta(Consulta miConsulta) {
		misConsultas.add(miConsulta);
		consultaCodigo++;
	}

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}


	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}


	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}


	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}
	
	public int cantPacientesPorEnfermedad(String idEnfermedad) {
		int cant = 0;
		
		for(Consulta aux : misConsultas) {
			if(aux.getPaciente().isEstado() == true && aux.getDiagnostico().getId().equalsIgnoreCase(idEnfermedad))
				cant++;
		}
		
		return cant;
	}


	public static String getPacienteCedula() {
		return pacienteCedula; 
	}


	public void setPacienteCedula(String pacienteCedula) {
		this.pacienteCedula = pacienteCedula;
	}


	public static String getMedicoCedula() {
		return medicoCedula;
	}


	public void setMedicoCedula(String medicoCedula) {
		this.medicoCedula = medicoCedula;
	}


	public void modificarVac(Vacuna vac) {
		int cont = buscarIndexVacByCode(vac.getCodigo());
		misVacunas.set(cont, vac);

	}
	
	public void eliminarVac(Vacuna select) {
		int cont;
		cont = misVacunas.indexOf(select);
		misVacunas.remove(cont);
	}

	
	/*vacuna
	private void vacunasUsadas(){
		for (Vacuna vac : misVacunas) {
			tipo = vac.getTipo();
			
			if(tipo != tipomax)
			{
				for (Vacuna vacs : misVacunas) {
					if(vacs.getTipo() == tipo)
						cant++;
				}	
			}
			
			if(cant > cantmax)
			{
				cantmax = cant;
				tipomax = tipo;
				cant = 0;
			}
				
	
		}
	}*/
}
