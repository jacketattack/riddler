package com.github.jacketattack.riddler.entity

import jakarta.persistence.*

@Entity
open class GameConfig(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    open var id: Long? = null,
    open var questionFrequencySeconds: Int,
    open var pointsPerQuestion: Int,
    open var seasonLengthDays: Int
)

@Entity
open class Question(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    open var id: Long? = null,
    open var text: String,
    open var answer: String,
    @ManyToOne(fetch = FetchType.LAZY)
    open var game: Game? = null
)

@Entity
open class Player(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    open var id: Long? = null,
    open var name: String,
    open var slackUserId: String,
    @ManyToOne(fetch = FetchType.LAZY)
    open var game: Game? = null,
    open var points: Int = 0
)

@Entity
open class Game(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    open var id: Long? = null,
    @OneToOne(cascade = [CascadeType.ALL])
    open var config: GameConfig,
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
    open var questions: MutableList<Question> = mutableListOf(),
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
    open var players: MutableList<Player> = mutableListOf()
)
