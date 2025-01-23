extends CharacterBody2D

func _ready():
	self.add_to_group("unbricks")

func sound():
	$DaniPop.play()
