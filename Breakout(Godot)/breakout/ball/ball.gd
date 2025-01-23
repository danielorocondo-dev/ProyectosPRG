extends CharacterBody2D

@export var speed = 500
var sobre_jugador = false
var jugador

var swiping = false             
var swipe_start = Vector2.ZERO  
var swipe_end = Vector2.ZERO    
var swipe_start_time = 0.0      

func reset_ball(node_jugador):
	GameData.brick_counter=1
	jugador = node_jugador  # Assigna la referència
	sobre_jugador=true
	velocity = Vector2.ZERO  # Atura qualsevol moviment
	position = jugador.global_position + Vector2(0, -25)  # Ajust vertical perquè estiga damunt

func _input(event):
	if event is InputEventMouseButton or event is InputEventScreenTouch:
		if event.is_pressed():
			swiping = true
			swipe_start = event.position
			swipe_start_time = Time.get_ticks_msec() / 1000.0
		else:  # Quan s’allibera el clic/toc...
			swiping = false
			swipe_end = event.position
			var swipe_duration = Time.get_ticks_msec() / 1000.0 - swipe_start_time  # Duració del drag
			if swipe_duration < 0.5 and swipe_start!=swipe_end:
				_throw_ball(swipe_start, swipe_end, swipe_duration)
	if Input.is_action_pressed("throw_ball") && sobre_jugador == true && GameData.game_over!=true:
		sobre_jugador = false
		velocity = Vector2(jugador.velocity.normalized().x, -1).normalized() * speed
		
# Funcio per llançar la pilota
func _throw_ball(start, end, duration):
	if GameData.game_over or not sobre_jugador:  
		return

	var direction = (end - start).normalized()
	
	var speed = min((end - start).length() / duration, 800)  

	sobre_jugador = false   # La pilota ja no esta sobre el jugador
	if speed < 450:
		velocity = direction * 450
		
	else:
		velocity = direction * speed
	
func _ready():
	set_ball_velocity()

func set_ball_velocity():
	if randi() % 2 == 0:
		velocity.x = 1
	else:
		velocity.x = -1
	velocity.y = -1
	if randi() % 2 ==0:
		velocity.y=1
	else:
		velocity.y=-1
	velocity *= speed

func _physics_process(delta):
	if Input.is_action_pressed("truco_bola"):
		velocity.x = -1  # Atura qualsevol moviment
		velocity.y = -1
		velocity *= speed  # Atura qualsevol moviment
		position = Vector2(358,70)  # Ajust vertical perquè estiga damunt
	if Input.is_action_pressed("MUERE_BOLA"):
		velocity.x = 0  # Atura qualsevol moviment
		velocity.y = 1
		velocity *= speed  # Atura qualsevol moviment
		position = Vector2(123,1144)
		
	if sobre_jugador and jugador:
		position = jugador.global_position + Vector2(0, -30)  # Ajust vertical perquè estiga damunt
		return

	if not self.visible:
		return

	var info_colissio=move_and_collide(velocity*delta)

	if info_colissio:
		velocity=velocity.bounce(info_colissio.get_normal())

		var ObjecteCollissionat=info_colissio.get_collider()

		if "players" in ObjecteCollissionat.get_groups():
			$bolachoque.play()
			GameData.brick_counter=1
		if ("bricks" in ObjecteCollissionat.get_groups()):
			ObjecteCollissionat.destroy()
			GameData.brick_counter+=1
		if ("unbricks" in ObjecteCollissionat.get_groups()):
			ObjecteCollissionat.sound()
