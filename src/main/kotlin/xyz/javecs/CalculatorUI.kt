package xyz.javecs

import com.vaadin.annotations.Theme
import com.vaadin.event.ShortcutAction
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
import xyz.javecs.tools.expr.Calculator

@Theme("valo")
@SpringUI
class CalculatorUI : UI() {
    val calc = Calculator()
    val layout = VerticalLayout()

    val textField = TextField().apply {
        placeholder = "数式入力..."
    }

    val button = Button("計算").apply {
        addClickListener({ _ ->
            try {
                val expr = textField.value
                layout.addComponent(Label("$expr : ${calc.eval(expr).value}"))
            } catch (e: Exception) {
                Notification.show(e.message, Notification.Type.WARNING_MESSAGE)
            }
            textField.clear()
        })
        setClickShortcut(ShortcutAction.KeyCode.ENTER)
    }

    override fun init(request: VaadinRequest?) {
        layout.addComponent(HorizontalLayout().apply {
            addComponents(button, textField)
        })
        content = layout
    }
}