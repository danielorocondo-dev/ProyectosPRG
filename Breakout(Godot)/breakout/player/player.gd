extends CharacterBody2D

class_name Jugador
var touch_x = null 

@export var speed = 500
func _ready() -> void:
	self.add_to_group("players")

func _input(event):
	if event is InputEventMouseButton:
		if event.is_pressed():
			touch_x = event.position.x
		else:
			touch_x = null
	elif event is InputEventMouseMotion and touch_x != null:
		touch_x = event.position.x

func _physics_process(delta):
	if GameData.game_over:
		return

	velocity = Vector2.ZERO

	if touch_x != null:
		#  Si es aixi, movem el jugador cap a la posicio touch_x
		velocity.x = (touch_x - global_position.x) * speed * delta
	else:
		# Si no s'esta utilitzant la pantalla tactil, comprovem el gamepad/teclat
		var input_axis = Input.get_action_strength("move_right") - Input.get_action_strength("move_left")
		velocity.x = input_axis * speed

	# Movem el jugador
	move_and_collide(velocity * delta)
