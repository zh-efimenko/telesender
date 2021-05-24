package me.eefimenko.telesender.handler.message

import me.eefimenko.telesender.model.telegram.recieve.Message
import me.eefimenko.telesender.model.telegram.send.SendMessage
import me.eefimenko.telesender.model.telegram.send.TextSendMessage

/**
 * @author Yauheni Yefimenka
 */
typealias ProcessBlock = (state: MessageHandlerState, answers: Map<String, Any>) -> SendMessage?
typealias QuestionBlock = (MessageHandlerState) -> TextSendMessage
typealias ValidationBlock<T> = (Message) -> T
