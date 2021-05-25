package me.eefimenko.telesender.handler

import me.eefimenko.telesender.handler.message.MessageHandlerState
import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Message
import me.eefimenko.telesender.model.telegram.recieve.Poll
import me.eefimenko.telesender.model.telegram.recieve.PollAnswer
import me.eefimenko.telesender.model.telegram.recieve.inline.CallbackQuery
import me.eefimenko.telesender.model.telegram.send.SendMessage
import me.eefimenko.telesender.model.telegram.send.TextSendMessage

/**
 * @author Yauheni Yefimenka
 */

// message handler
typealias MessageProcessBlock = (chat: Chat, answers: Map<String, Any>) -> SendMessage?
typealias MessageQuestionBlock = (MessageHandlerState) -> TextSendMessage
typealias MessageValidationBlock<T> = (Message) -> T

// callbackQuery handler
typealias CallbackQueryProcessBlock = (callbackQuery: CallbackQuery) -> SendMessage?

// poll handler
typealias PollProcessBlock = (poll: Poll) -> SendMessage?

// pollAnswer handler
typealias PollAnswerProcessBlock = (pollAnswer: PollAnswer) -> SendMessage?
