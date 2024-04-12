MISSION_START
			  
//IMPORT EXPORT VARIABLES
VAR_INT	whiteboard_garage_slots_filled create_car_pickups_industrial changed_whiteboard_garage
VAR_INT whiteboard_slot1 whiteboard_slot2 whiteboard_slot3 whiteboard_slot4 whiteboard_slot5 whiteboard_slot6 
VAR_INT import_export_sign1 
VAR_INT	score_off_1 score_off_2 score_off_3 score_off_4 score_off_5 score_off_6	 
VAR_INT deluxo_prize_car sabretur_prize_car sandking_prize_car Hotring_prize_car
VAR_INT deluxo_car_been_created sabretur_car_been_created sandking_car_been_created hotring_car_been_created

whiteboard_garage_slots_filled = 0
changed_whiteboard_garage = 0
deluxo_car_been_created = 0
sabretur_car_been_created = 0
sandking_car_been_created = 0
hotring_car_been_created = 0

SCRIPT_NAME	import

SET_DEATHARREST_STATE OFF

//IMPORT EXPORT GARAGE1***************************************************************************************

mission_import_start:

{
	GOTO dont_create_this_object

	CREATE_OBJECT_NO_OFFSET lh_imp_exp01 -981.754 -841.278 8.586 import_export_sign1
	DONT_REMOVE_OBJECT import_export_sign1

	dont_create_this_object:
	
	MISSION_END
}
	 

import1_loop:
{
//	Should be called in mission_import_start

	SCRIPT_NAME IMPORT1

import1_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING player1

		IF IS_PLAYER_IN_ZONE player1 HAVANA

			IF NOT whiteboard_garage_slots_filled = 6

				GOSUB check_if_import_slot_filled

			ELSE //IF whiteboard_garage_slots_filled = 6

				IF changed_whiteboard_garage = 0
					
					GOSUB delete_import_signs

					CHANGE_GARAGE_TYPE collect_all_cars1 GARAGE_COLLECTCARS_2
					CREATE_OBJECT_NO_OFFSET lh_imp_exp02 -981.754 -841.278 8.586 import_export_sign1
					DONT_REMOVE_OBJECT import_export_sign1
					++ counter_60_percent
					showroom_asset_acquired = 1
					CREATE_PROTECTION_PICKUP carbuyX carbuyY carbuyZ showroom_revenue showroom_revenue showroom_cash_pickup
					REGISTER_MISSION_GIVEN
					REGISTER_ODDJOB_MISSION_PASSED

					changed_whiteboard_garage = 1
						
					WAIT 1000

					IF IS_PLAYER_PLAYING player1

						SET_PLAYER_CONTROL player1 OFF

						DO_FADE 500 FADE_OUT
												
						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						SWITCH_WIDESCREEN ON

						REQUEST_MODEL deluxo
						LOAD_ALL_MODELS_NOW

						WHILE NOT HAS_MODEL_LOADED deluxo
							WAIT 0
						ENDWHILE

						CREATE_CAR deluxo -1022.3 -868.2 12.0 deluxo_prize_car
						SET_CAR_HEADING deluxo_prize_car 175.0
						deluxo_car_been_created = 1

						LOAD_SCENE -1027.755 -870.693 13.398
						SET_FIXED_CAMERA_POSITION -1028.692 -871.013 13.541 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1027.755 -870.693 13.398 JUMP_CUT
						
						DO_FADE 500 FADE_IN

						WAIT 4000
							
						LOAD_SCENE -1019.562 -865.229 13.506
						SET_FIXED_CAMERA_POSITION -1018.839 -864.582 13.748 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1019.562 -865.229 13.506 JUMP_CUT

						WAIT 4000

						DO_FADE 500 FADE_OUT

						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						LOAD_SCENE -1033.841 -904.032 17.364
						SET_FIXED_CAMERA_POSITION -1034.135 -904.978 17.500 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1033.841 -904.032 17.364 JUMP_CUT
						DO_FADE 500 FADE_IN
						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						PLAY_MISSION_PASSED_TUNE 1
						PRINT_BIG CAR_AS1 5000 6//CAR ASSET ACQUIRED

						WAIT 5000
						LOAD_SCENE -1008.388 -873.565 13.218
						SET_FIXED_CAMERA_POSITION -1007.333 -874.260 13.824 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1007.340 -873.279 13.630 JUMP_CUT
						PRINT_WITH_NUMBER_NOW CAR_AS2 showroom_revenue 6000 1//The car showroom will now generate revenue upto a maximum of $~1~. Make sure you collect it regulary.

						WAIT 6000
						DO_FADE 500 FADE_OUT
						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE
						DO_FADE 500 FADE_IN

						IF IS_PLAYER_PLAYING player1

							SET_PLAYER_CONTROL player1 ON
							SWITCH_WIDESCREEN OFF
							RESTORE_CAMERA_JUMPCUT

						ENDIF
					// SCFIX: START
					ELSE
						deluxo_car_been_created = 1
						import_car_generator1_created = 1
						SWITCH_CAR_GENERATOR deluxo_prize_car_gen 101
					// SCFIX: END
					ENDIF

					GOSUB clean_up_import_varibles
					
					flag_first_asset_complete = 1 // SCFIX: fix Ken's phonecall
					GET_GAME_TIMER timer_mobile_start // SCFIX
					
					PLAYER_MADE_PROGRESS 1
					START_NEW_SCRIPT import2_loop
					IF import_car_generator1_created = 0 // SCFIX
						START_NEW_SCRIPT create_car_generator1
					ENDIF // SCFIX
					TERMINATE_THIS_SCRIPT
				ENDIF

			ENDIF //IF industrial_garage_slots = 6

		ENDIF	//	IF IS_PLAYER_IN_ZONE player1 HAVANA

	ENDIF	//	IF IS_PLAYER_PLAYING player1


GOTO import1_loop_inner
}



import2_loop:
{
//	Should be called in mission_import_start

	SCRIPT_NAME IMPORT2

import2_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING player1

		IF IS_PLAYER_IN_ZONE player1 HAVANA

			IF NOT whiteboard_garage_slots_filled = 6

				GOSUB check_if_import_slot_filled

			ELSE //IF whiteboard_garage_slots_filled = 6

				IF changed_whiteboard_garage = 0
					
					GOSUB delete_import_signs

					CHANGE_GARAGE_TYPE collect_all_cars1 GARAGE_COLLECTCARS_3
					CREATE_OBJECT_NO_OFFSET lh_imp_exp03 -981.754 -841.278 8.586 import_export_sign1
					DONT_REMOVE_OBJECT import_export_sign1
					showroom_revenue = showroom_revenue + 2500
					REMOVE_PICKUP showroom_cash_pickup
					CREATE_PROTECTION_PICKUP carbuyX carbuyY carbuyZ showroom_revenue showroom_revenue showroom_cash_pickup
					REGISTER_MISSION_GIVEN
					REGISTER_ODDJOB_MISSION_PASSED

					changed_whiteboard_garage = 1

					WAIT 1000
					
					IF IS_PLAYER_PLAYING player1

						SET_PLAYER_CONTROL player1 OFF

						DO_FADE 500 FADE_OUT
												
						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						SWITCH_WIDESCREEN ON

						REQUEST_MODEL sabretur
						LOAD_ALL_MODELS_NOW

						WHILE NOT HAS_MODEL_LOADED sabretur
							WAIT 0
						ENDWHILE

						CREATE_CAR sabretur -1014.1 -869.4 12.0 sabretur_prize_car
						SET_CAR_HEADING sabretur_prize_car 188.0
						sabretur_car_been_created = 1

						LOAD_SCENE -1012.449 -874.397 13.795
						SET_FIXED_CAMERA_POSITION -1012.101 -875.321 13.952 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1012.449 -874.397 13.795 JUMP_CUT
						
						DO_FADE 500 FADE_IN

						WAIT 4000
						
						LOAD_SCENE -1016.831 -866.517 13.734
						SET_FIXED_CAMERA_POSITION -1017.595 -865.969 14.074 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1016.831 -866.517 13.734 JUMP_CUT

						WAIT 4000

						IF IS_PLAYER_PLAYING player1

							SET_PLAYER_CONTROL player1 ON
							SWITCH_WIDESCREEN OFF
							RESTORE_CAMERA_JUMPCUT
							PRINT_WITH_NUMBER_NOW CAR_AS2 showroom_revenue 6000 1//The car showroom will now generate revenue upto a maximum of $~1~. Make sure you collect it regulary.

						ENDIF
					// SCFIX: START
					ELSE
						sabretur_car_been_created = 1
						import_car_generator2_created = 1
						SWITCH_CAR_GENERATOR sabretur_prize_car_gen 101
					// SCFIX: END
					ENDIF
					
					GOSUB clean_up_import_varibles

					PLAYER_MADE_PROGRESS 1
					START_NEW_SCRIPT import3_loop
					IF import_car_generator2_created = 0 // SCFIX
						START_NEW_SCRIPT create_car_generator2
					ENDIF // SCFIX
					TERMINATE_THIS_SCRIPT
				ENDIF

			ENDIF //IF industrial_garage_slots = 6

		ENDIF	//	IF IS_PLAYER_IN_ZONE player1 HAVANA

	ENDIF	//	IF IS_PLAYER_PLAYING player1


GOTO import2_loop_inner
}


import3_loop:
{
//	Should be called in mission_import_start

	SCRIPT_NAME IMPORT3

import3_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING player1

		IF IS_PLAYER_IN_ZONE player1 HAVANA

			IF NOT whiteboard_garage_slots_filled = 6

				GOSUB check_if_import_slot_filled

			ELSE //IF whiteboard_garage_slots_filled = 6

				IF changed_whiteboard_garage = 0
					
					GOSUB delete_import_signs

					CHANGE_GARAGE_TYPE collect_all_cars1 GARAGE_COLLECTCARS_4
					CREATE_OBJECT_NO_OFFSET lh_imp_exp04 -981.754 -841.278 8.586 import_export_sign1
					DONT_REMOVE_OBJECT import_export_sign1
					showroom_revenue = showroom_revenue + 2500
					REMOVE_PICKUP showroom_cash_pickup
					CREATE_PROTECTION_PICKUP carbuyX carbuyY carbuyZ showroom_revenue showroom_revenue showroom_cash_pickup
					REGISTER_MISSION_GIVEN
					REGISTER_ODDJOB_MISSION_PASSED

					changed_whiteboard_garage = 1

					WAIT 1000

					IF IS_PLAYER_PLAYING player1

						SET_PLAYER_CONTROL player1 OFF

						DO_FADE 500 FADE_OUT 
						
						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						SWITCH_WIDESCREEN ON

						REQUEST_MODEL sandking
						LOAD_ALL_MODELS_NOW

						WHILE NOT HAS_MODEL_LOADED sandking
							WAIT 0
						ENDWHILE

						CREATE_CAR sandking -1014.3 -868.8 17.7 sandking_prize_car
						SET_CAR_HEADING sandking_prize_car 195.0
						sandking_car_been_created = 1

						LOAD_SCENE -1009.532 -871.888 19.307
						SET_FIXED_CAMERA_POSITION -1008.656 -872.307 19.548 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1009.532 -871.888 19.307 JUMP_CUT
						
						DO_FADE 500 FADE_IN

						WAIT 4000
						
						LOAD_SCENE -1018.040 -871.539 20.058
						SET_FIXED_CAMERA_POSITION -1018.791 -872.077 20.442 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1018.040 -871.539 20.058 JUMP_CUT

						WAIT 4000

						IF IS_PLAYER_PLAYING player1

							SET_PLAYER_CONTROL player1 ON
							SWITCH_WIDESCREEN OFF
							RESTORE_CAMERA_JUMPCUT
							PRINT_WITH_NUMBER_NOW CAR_AS2 showroom_revenue 6000 1//The car showroom will now generate revenue upto a maximum of $~1~. Make sure you collect it regulary.
						ENDIF

					// SCFIX: START
					ELSE
						sandking_car_been_created = 1
						import_car_generator3_created = 1
						SWITCH_CAR_GENERATOR sandking_prize_car_gen 101
					// SCFIX: END
					ENDIF
					
					GOSUB clean_up_import_varibles

					PLAYER_MADE_PROGRESS 1
					START_NEW_SCRIPT import4_loop
					IF import_car_generator3_created = 0 // SCFIX
						START_NEW_SCRIPT create_car_generator3
					ENDIF // SCFIX
					TERMINATE_THIS_SCRIPT
				ENDIF

			ENDIF //IF industrial_garage_slots = 6

		ENDIF	//	IF IS_PLAYER_IN_ZONE player1 HAVANA

	ENDIF	//	IF IS_PLAYER_PLAYING player1


GOTO import3_loop_inner
}


import4_loop:
{
//	Should be called in mission_import_start

	SCRIPT_NAME IMPORT4

import4_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING player1

		IF IS_PLAYER_IN_ZONE player1 HAVANA

			IF NOT whiteboard_garage_slots_filled = 6

				GOSUB check_if_import_slot_filled	

			ELSE //IF whiteboard_garage_slots_filled = 6

				IF changed_whiteboard_garage = 0
					
					showroom_revenue = showroom_revenue + 2500
					REMOVE_PICKUP showroom_cash_pickup
					CREATE_PROTECTION_PICKUP carbuyX carbuyY carbuyZ showroom_revenue showroom_revenue showroom_cash_pickup
					REGISTER_MISSION_GIVEN
					REGISTER_ODDJOB_MISSION_PASSED

					changed_whiteboard_garage = 1

					WAIT 1000

					IF IS_PLAYER_PLAYING player1

						SET_PLAYER_CONTROL player1 OFF
						
						DO_FADE 500 FADE_OUT
												
						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						SWITCH_WIDESCREEN ON

						REQUEST_MODEL Hotring
						LOAD_ALL_MODELS_NOW

						WHILE NOT HAS_MODEL_LOADED Hotring
							WAIT 0
						ENDWHILE

						CREATE_CAR Hotring -1023.2 -868.1 17.0 Hotring_prize_car
						SET_CAR_HEADING Hotring_prize_car 172.0
						Hotring_car_been_created = 1

						LOAD_SCENE -1026.903 -871.942 19.008
						SET_FIXED_CAMERA_POSITION -1027.585 -872.634 19.244 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1026.903 -871.942 19.008 JUMP_CUT
						
						DO_FADE 500 FADE_IN

						WAIT 4000
						
						LOAD_SCENE -1019.624 -869.584 18.612
						SET_FIXED_CAMERA_POSITION -1018.721 -869.948 18.844 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -1019.624 -869.584 18.612 JUMP_CUT

						WAIT 4000

						IF IS_PLAYER_PLAYING player1

							SET_PLAYER_CONTROL player1 ON
							SWITCH_WIDESCREEN OFF
							RESTORE_CAMERA_JUMPCUT
							PRINT_WITH_NUMBER_NOW CAR_AS2 showroom_revenue 6000 1//The printworks will now generate revenue upto a maximum of $~1~. Make sure you collect it regulary.
						ENDIF

					// SCFIX: START
					ELSE
						Hotring_car_been_created = 1
						import_car_generator4_created = 1
						SWITCH_CAR_GENERATOR Hotring_prize_car_gen 101
					// SCFIX: END
					ENDIF

					PLAYER_MADE_PROGRESS 1
					IF import_car_generator4_created = 0 // SCFIX
						START_NEW_SCRIPT create_car_generator4
					ENDIF // SCFIX
					TERMINATE_THIS_SCRIPT
				ENDIF

			ENDIF //IF industrial_garage_slots = 6

		ENDIF	//	IF IS_PLAYER_IN_ZONE player1 HAVANA

	ENDIF	//	IF IS_PLAYER_PLAYING player1


GOTO import4_loop_inner
}


create_car_generator1:
{

SCRIPT_NAME	IMPGEN1

create_car_generator1_inner:

WAIT 1000

		IF import_car_generator1_created = 0
			IF deluxo_car_been_created = 1
				IF IS_PLAYER_PLAYING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -1023.0 -860.4 15.0 100.0 100.0 40.0 FALSE
						IF NOT IS_CAR_DEAD deluxo_prize_car
							MARK_CAR_AS_NO_LONGER_NEEDED deluxo_prize_car
							MARK_MODEL_AS_NO_LONGER_NEEDED deluxo
							SWITCH_CAR_GENERATOR deluxo_prize_car_gen 101
						ELSE
							MARK_MODEL_AS_NO_LONGER_NEEDED deluxo
							SWITCH_CAR_GENERATOR deluxo_prize_car_gen 101
						ENDIF
						import_car_generator1_created = 1
						TERMINATE_THIS_SCRIPT
					ENDIF
				ENDIF
			ENDIF
		ENDIF


GOTO create_car_generator1_inner

}

create_car_generator2:
{

SCRIPT_NAME	IMPGEN2

create_car_generator2_inner:

WAIT 1000

		IF import_car_generator2_created = 0
			IF sabretur_car_been_created = 1
				IF IS_PLAYER_PLAYING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -1023.0 -860.4 15.0 100.0 100.0 40.0 FALSE
						IF NOT IS_CAR_DEAD sabretur_prize_car
							MARK_MODEL_AS_NO_LONGER_NEEDED sabretur
							MARK_CAR_AS_NO_LONGER_NEEDED sabretur_prize_car
							SWITCH_CAR_GENERATOR sabretur_prize_car_gen 101
						ELSE
							MARK_MODEL_AS_NO_LONGER_NEEDED sabretur
							SWITCH_CAR_GENERATOR sabretur_prize_car_gen 101
						ENDIF
						import_car_generator2_created = 1
						TERMINATE_THIS_SCRIPT
					ENDIF
				ENDIF
			ENDIF
		ENDIF


GOTO create_car_generator2_inner

}

create_car_generator3:
{

SCRIPT_NAME	IMPGEN3

create_car_generator3_inner:

WAIT 1000

		IF import_car_generator3_created = 0
			IF sandking_car_been_created = 1
				IF IS_PLAYER_PLAYING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -1023.0 -860.4 15.0 100.0 100.0 40.0 FALSE
						IF NOT IS_CAR_DEAD sandking_prize_car
							MARK_MODEL_AS_NO_LONGER_NEEDED sandking
							MARK_CAR_AS_NO_LONGER_NEEDED sandking_prize_car
							SWITCH_CAR_GENERATOR sandking_prize_car_gen 101
						ELSE
							MARK_MODEL_AS_NO_LONGER_NEEDED sandking
							SWITCH_CAR_GENERATOR sandking_prize_car_gen 101
						ENDIF
						import_car_generator3_created = 1
						TERMINATE_THIS_SCRIPT
					ENDIF
				ENDIF
			ENDIF
		ENDIF


GOTO create_car_generator3_inner

}

create_car_generator4:
{

SCRIPT_NAME	IMPGEN4

create_car_generator4_inner:

WAIT 1000

		IF import_car_generator4_created = 0
			IF Hotring_car_been_created = 1
				IF IS_PLAYER_PLAYING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -1023.0 -860.4 15.0 100.0 100.0 40.0 FALSE
						IF NOT IS_CAR_DEAD Hotring_prize_car
							MARK_MODEL_AS_NO_LONGER_NEEDED Hotring
							MARK_CAR_AS_NO_LONGER_NEEDED Hotring_prize_car
							SWITCH_CAR_GENERATOR Hotring_prize_car_gen 101
						ELSE
							MARK_MODEL_AS_NO_LONGER_NEEDED Hotring
							SWITCH_CAR_GENERATOR Hotring_prize_car_gen 101
						ENDIF
						import_car_generator4_created = 1
						TERMINATE_THIS_SCRIPT
					ENDIF
				ENDIF
			ENDIF
		ENDIF


GOTO create_car_generator4_inner


check_if_import_slot_filled:

	IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 1
	AND whiteboard_slot1 = 0
		whiteboard_garage_slots_filled ++
		CREATE_OBJECT_NO_OFFSET lh_strikethrough -981.519 -841.222 8.378 score_off_1
		DONT_REMOVE_OBJECT score_off_1
		whiteboard_slot1 = 1 
	ENDIF

	IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 2
	AND whiteboard_slot2 = 0
		whiteboard_garage_slots_filled ++
		CREATE_OBJECT_NO_OFFSET lh_strikethrough -981.519 -841.222 8.216 score_off_2
		DONT_REMOVE_OBJECT score_off_2
		whiteboard_slot2 = 1 
	ENDIF

	IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 3
	AND whiteboard_slot3 = 0
		whiteboard_garage_slots_filled ++
		CREATE_OBJECT_NO_OFFSET lh_strikethrough -981.519 -841.222 8.062 score_off_3
		DONT_REMOVE_OBJECT score_off_3
		whiteboard_slot3 = 1 
	ENDIF

	IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 4
	AND whiteboard_slot4 = 0
		whiteboard_garage_slots_filled ++
		CREATE_OBJECT_NO_OFFSET lh_strikethrough -981.519 -841.222 7.901 score_off_4
		DONT_REMOVE_OBJECT score_off_4
		whiteboard_slot4 = 1 
	ENDIF

	IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 5
	AND whiteboard_slot5 = 0
		whiteboard_garage_slots_filled ++
		CREATE_OBJECT_NO_OFFSET lh_strikethrough -981.519 -841.222 7.740 score_off_5
		DONT_REMOVE_OBJECT score_off_5
		whiteboard_slot5 = 1 
	ENDIF

	IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 6
	AND whiteboard_slot6 = 0
		whiteboard_garage_slots_filled ++
		CREATE_OBJECT_NO_OFFSET lh_strikethrough -981.519 -841.222 7.585 score_off_6
		DONT_REMOVE_OBJECT score_off_6
		whiteboard_slot6 = 1 
	ENDIF


RETURN


clean_up_import_varibles:

	whiteboard_slot1 = 0
	whiteboard_slot2 = 0
	whiteboard_slot3 = 0
	whiteboard_slot4 = 0
	whiteboard_slot5 = 0
	whiteboard_slot6 = 0
	whiteboard_garage_slots_filled = 0
	changed_whiteboard_garage = 0

RETURN


delete_import_signs:

	DELETE_OBJECT score_off_1
	DELETE_OBJECT score_off_2
	DELETE_OBJECT score_off_4
	DELETE_OBJECT score_off_3
	DELETE_OBJECT score_off_5
	DELETE_OBJECT score_off_6
	DELETE_OBJECT import_export_sign1

RETURN

}