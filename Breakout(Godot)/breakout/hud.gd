extends CanvasLayer
func _ready():
	$ScoreLabel.text = str(GameData.score)
	$ControlVidas.pinta_vides(GameData.lives)
	$Button.connect("pressed",Callable(self,"on_BotoReinici_pressed"))
	GameData.connect("lives_changed", Callable(self, "_on_lives_changed"))
	GameData.connect("score_changed", Callable(self, "_on_score_changed"))

func on_BotoReinici_pressed():
	GameData.score=0
	GameData.lives=3
	GameData.game_over=false
	GameData.current_level=0
	get_tree().change_scene_to_file("res://breakout.tscn")

func _on_lives_changed(vides):
	$ControlVidas.pinta_vides(vides)
func _on_score_changed(new_score):
	$ScoreLabel.text = str(new_score)
