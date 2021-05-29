package io.github.telesender.handler

import io.github.telesender.handler.message.MessageHandlerState
import io.github.telesender.model.telegram.recieve.Message
import io.github.telesender.model.telegram.recieve.Poll
import io.github.telesender.model.telegram.recieve.PollAnswer
import io.github.telesender.model.telegram.recieve.inline.CallbackQuery
import io.github.telesender.model.telegram.send.SendMessage
import io.github.telesender.model.telegram.send.TextSendMessage

/**
 * @author Yauheni Yefimenka
 */

// message handler
typealias MessageProcessBlock = (message: Message, answers: Map<String, Any>) -> SendMessage?
typealias MessageQuestionBlock = (MessageHandlerState) -> TextSendMessage
typealias MessageValidationBlock<T> = (Message) -> T

// callbackQuery handler
typealias CallbackQueryProcessBlock = (callbackQuery: CallbackQuery) -> SendMessage?

// poll handler
typealias PollProcessBlock = (poll: Poll) -> SendMessage?

// pollAnswer handler
typealias PollAnswerProcessBlock = (pollAnswer: PollAnswer) -> SendMessage?
