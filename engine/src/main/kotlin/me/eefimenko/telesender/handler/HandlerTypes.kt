package me.eefimenko.telesender.handler

import me.eefimenko.telesender.handler.message.MessageHandlerState
import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Message
import me.eefimenko.telesender.model.telegram.send.SendMessage
import me.eefimenko.telesender.model.telegram.send.TextSendMessage

/**
 * @author Yauheni Yefimenka
 */

typealias ProcessBlock = (chat: Chat, params: Map<String, Any>) -> SendMessage?

// message handler
typealias MessageQuestionBlock = (MessageHandlerState) -> TextSendMessage
typealias MessageValidationBlock<T> = (Message) -> T
