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
    val layout = VerticalLayout()

    val expr = TextArea().apply {
        placeholder = "数式入力..."
        rows = 1
    }

    val eval = Button("計算", { _ ->
        try {
            val value = eval(expr.value).toString()
            layout.addComponent(Label("${expr.value} = $value"))
        } catch (e: Exception) {
            Notification.show(e.message, Notification.Type.WARNING_MESSAGE)
        }
    })

    override fun init(request: VaadinRequest?) {
        layout.addComponent(HorizontalLayout().apply {
            addComponents(eval, expr)
        })
        content = layout
    }
}