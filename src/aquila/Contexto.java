package aquila;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import aquila.algoritmos.Cobertura;
import aquila.comandos.Linguagem;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Tupla;


//Singleton que armazena informacoes do contexto do parser, como para qual linguagem esta sendo gerado o codigo do output,
//o algoritmo para fazer a cobertura da FSM e gerar o codigo final. Pode ser acessado em qualquer ponto do programa 
//usando Contexto.getContext(). Inclui tambem todas as FSM geradas, podem ser usadas com o comando {} da linguagem aquila

public class Contexto {
	
	private static Contexto instance = null;
	private Linguagem linguagem = null;
	private Cobertura cobertura = null;
	private String arqSaida = "";
	private String arqEntrada = "";
	private boolean gerarBib = false;
	
	
	private List<String> metodos = null;
	private Map<String, Tupla<FSM, State>> contexto;
	
	public static Contexto getContext()
	{
		if(instance == null) instance = new Contexto();
		return instance;
	}
	
	private Contexto()
	{
		contexto = new HashMap<String, Tupla<FSM, State>>();
		metodos = new LinkedList<String>();
	}
	
	public  Tupla<FSM, State> getFSM(String nome)
	{	
		return contexto.get(nome);
	}
	
	public  Tupla<FSM, State> addFSM(String nome, Tupla<FSM, State> tup)
	{
		return contexto.put(nome, tup);
	}

	public  Linguagem getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(Linguagem linguagem) {
		this.linguagem = linguagem;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	
	public List<String> listaMetodos()
	{
		return this.metodos;
	}
	public void addMethod(String nome)
	{
		this.metodos.add(nome);
	}

	public String getArqSaida() {
		return arqSaida;
	}

	public void setArqSaida(String arqSaida) {
		this.arqSaida = arqSaida;
	}

	public String getArqEntrada() {
		return arqEntrada;
	}

	public void setArqEntrada(String arqEntrada) {
		this.arqEntrada = arqEntrada;
	}

	public boolean isGerarBib() {
		return gerarBib;
	}

	public void setGerarBib(boolean gerarBib) {
		this.gerarBib = gerarBib;
	}
}
