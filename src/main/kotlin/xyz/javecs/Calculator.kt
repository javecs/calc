package xyz.javecs

import com.vaadin.annotations.Theme
import com.vaadin.event.ShortcutAction
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
import xyz.javecs.tools.expr.eval

@Theme("valo")
@SpringUI
class Calculator : UI() {
    val layout = VerticalLayout()

    val expr = TextField().apply {
        placeholder = "数式入力..."
    }

    val eval = Button("計算").apply {
        addClickListener({ _ ->
            try {
                val value = eval(expr.value).toString()
                layout.addComponent(Label("${expr.value} = $value"))
            } catch (e: Exception) {
                Notification.show(e.message, Notification.Type.WARNING_MESSAGE)
            }
        })
        setClickShortcut(ShortcutAction.KeyCode.ENTER)
    }

    override fun init(request: VaadinRequest?) {
        layout.addComponent(HorizontalLayout().apply {
            addComponents(eval, expr)
        })
        content = layout
    }
}