extends CharacterBody2D

func _ready():
	self.add_to_group("bricks")

func destroy():
	$CollisionShape2D.disabled = true
	GameData.score+=100*GameData.brick_counter
	$AudioStreamPlayer.play()
	var tween = create_tween()
	tween.tween_property($Sprite2D, "modulate:a", 0.0, 0.3)
	tween.finished.connect(func():
		queue_free()
		LevelManager.comprova_nombre_bricks()
		)
