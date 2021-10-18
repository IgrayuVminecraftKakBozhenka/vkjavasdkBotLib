package Keyboards

import com.vk.api.sdk.objects.messages.*


fun getKeyboardButton(label: String, type: TemplateActionTypeNames, color: KeyboardButtonColor): KeyboardButton {
    return KeyboardButton().setAction(KeyboardButtonAction().setLabel(label).setType(type)).setColor(color)
}




