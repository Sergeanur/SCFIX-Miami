MISSION_START

// FIXMIAMI: START - fix SSU shit
GOSUB mission_start_buypro1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_deatharrest_buypro1
ENDIF

GOSUB mission_cleanup_buypro1

MISSION_END
// FIXMIAMI: END
			  

mission_start_buypro1:

SCRIPT_NAME	buypro1

flag_player_on_mission = 1
{ // FIXMIAMI: scope moved up, was after WAIT 0

// FIXMIAMI: START
LVAR_INT flag_buypro1_set1
LVAR_INT flag_buypro1_set2
LVAR_INT flag_buypro1_set3
flag_buypro1_set1 = 0
flag_buypro1_set2 = 0
flag_buypro1_set3 = 0
// FIXMIAMI: END

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before wait

WAIT 0
	GOSUB buypro1_set1 // FIXMIAMI: moved stuff into a subroutine

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
			START_NEW_SCRIPT counter_mission1_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	CLEAR_AREA -1059.8411 -278.7214 10.4044 1.0 TRUE
	SET_PLAYER_COORDINATES player1 -1059.8411 -278.7214 10.4044
	SET_PLAYER_HEADING player1 90.0
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION -1027.3385 -281.6154 16.3511 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -1028.1625 -281.0542 16.2730 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
			START_NEW_SCRIPT counter_mission1_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	PRINT_WITH_NUMBER_BIG CNTBUY1 printworks_price 4000 6 //"Printworks purchased: $ 15000"
	GOSUB buypro1_set2 // FIXMIAMI: moved stuff into a subroutine

	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 4000

	/* FIXMIAMI: remove this shit
	IF NOT IS_PLAYER_PLAYING player1
		SET_MUSIC_DOES_FADE TRUE
		ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
		START_NEW_SCRIPT counter_mission1_loop
		TERMINATE_THIS_SCRIPT
	ENDIF
	*/

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove SSU shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
			ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
			START_NEW_SCRIPT counter_mission1_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT

	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 FALSE
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
	SWITCH_WIDESCREEN OFF

	GOSUB buypro1_set3 // FIXMIAMI: moved stuff into a subroutine

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove SSU shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	RETURN // FIXMIAMI

// FIXMIAMI: START
buypro1_set1:
IF flag_buypro1_set1 = 0
	REMOVE_BLIP counter_contact_blip
	REMOVE_BLIP print_works_blip					
	PLAYER_MADE_PROGRESS 1
	SET_ZONE_PED_INFO PRINTWK DAY   (13) 0 0 0 0 0 0 1000 0 0 0
	SET_ZONE_PED_INFO PRINTWK NIGHT (10) 0 0 0 0 0 0 1000 0 0 0
	SWITCH_PED_ROADS_ON -1176.038 -266.898 0.0 -1012.796 -158.26 30.0//PRINTWORKS
	flag_buypro1_set1 = 1
ENDIF
RETURN

buypro1_set2:
IF flag_buypro1_set2 = 0
	ADD_MONEY_SPENT_ON_PROPERTY printworks_price
	SET_PROPERTY_AS_OWNED PROP_PRINTWORKS
	flag_buypro1_set2 = 1
ENDIF
RETURN

buypro1_set3:
IF flag_buypro1_set3 = 0
	ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip

	START_NEW_SCRIPT counter_mission1_loop
	flag_buypro1_set3 = 1
ENDIF
RETURN

mission_deatharrest_buypro1:
GOSUB buypro1_set1
GOSUB buypro1_set2
GOSUB buypro1_set3
RETURN
// FIXMIAMI: END

mission_cleanup_buypro1: // FIXMIAMI
	SET_MUSIC_DOES_FADE TRUE

START_NEW_SCRIPT printers_save_loop

flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: done above now

}
RETURN 

