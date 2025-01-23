extends Control
func pinta_vides(vides:int):
	for i in range(get_child_count()):
		var cor = get_child(i)
		if i < vides:
			cor.visible = true
		else:
			cor.visible = false
