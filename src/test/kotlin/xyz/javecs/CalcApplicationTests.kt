package xyz.javecs


import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import xyz.javecs.tools.expr.eval
import kotlin.test.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest
class CalcApplicationTests {

	@Test fun evalAdd() {
		assertEquals(7, eval("3 + 4"))
	}

}
