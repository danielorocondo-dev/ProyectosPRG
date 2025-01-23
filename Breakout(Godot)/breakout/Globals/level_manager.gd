extends Node

var levels = [
	"res://breakout.tscn",
	#"res://breakout_level2.tscn",
	"res://breakout_level3.tscn",
	]
func load_next_level():
	GameData.current_level += 1
	if GameData.current_level>=levels.size():
		GameData.current_level=0; # Joc infinit, quan arribem al final de les pantalles, tornem a començar
	get_tree().change_scene_to_file(levels[GameData.current_level])

func _pausa(ms):
	var timer = Timer.new() # Creem un temporitzador (timer)
	timer.wait_time = ms    # Establim el temps d'espera (wait_time)
	timer.one_shot = true   # Assegurem que siga d'us unic
	add_child(timer)        # Afegim el temporitzador a l'escena
	timer.start()           # Iniciem el temporitzador
	await timer.timeout     # Esperem que el temporitzador acabe

func comprova_nombre_bricks():
	await _pausa(0)
	if get_tree().get_nodes_in_group("bricks").size() == 0:
		load_next_level()
