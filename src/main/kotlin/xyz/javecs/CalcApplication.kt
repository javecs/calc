package xyz.javecs

import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import xyz.javecs.expr.eval

@SpringBootApplication
class CalcApplication

fun main(args: Array<String>) {
    SpringApplication.run(CalcApplication::class.java, *args)
}

@Theme("valo")
@SpringUI
class Calculator : UI() {
    val text = TextArea().apply {
        placeholder = "数式入力..."
        rows = 1
    }

    var eval = Button("計算", { _ ->
        Notification.show("${eval(text.value)}")
    })

    override fun init(request: VaadinRequest?) {
        content = HorizontalLayout().apply {
            setMargin(true)
            addComponents(eval, text)
        }
    }
}