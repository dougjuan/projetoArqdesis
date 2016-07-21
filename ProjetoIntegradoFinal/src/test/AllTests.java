package test;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DaoAlunoTest.class, DaoArtesTest.class, DaoInformaticaTest.class,ModelAlunoTest.class,
	ModelArtesTest.class,ModelInformaticaTest.class,TestaConexao.class, ToAlunoTest.class , ToArtesTest.class,
	ToInformaticaTest.class  })
public class AllTests {

}
