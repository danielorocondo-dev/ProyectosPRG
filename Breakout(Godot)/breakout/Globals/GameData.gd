extends Node

signal lives_changed(new_lives)
signal score_changed(new_score)
var game_over = false
var brick_counter = 1
var current_level=0

var lives: int = 3:
	set(value):
		lives = value
		emit_signal("lives_changed", lives)
		
var score: int = 0:
	set(value):
		score = value
		emit_signal("score_changed",score)
