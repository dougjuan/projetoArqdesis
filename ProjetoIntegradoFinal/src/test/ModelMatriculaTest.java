package test;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


import Model.ModelMatricula;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModelMatriculaTest{
	ModelMatricula mMatricula, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * ModelMatricula. 
	 * Certifique-se que a fixture mMatricula1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		mMatricula = new ModelMatricula(3, null,null,"OK","Finalizada");
		copia = new ModelMatricula(3,null,null,"OK","Finalizada");
	}
	
}