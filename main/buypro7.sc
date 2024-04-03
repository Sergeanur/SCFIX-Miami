MISSION_START
			  
// FIXMIAMI: START - fix SSU shit
GOSUB mission_start_hycobuy

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_deatharrest_hycobuy
ENDIF

GOSUB mission_cleanup_hycobuy

MISSION_END
// FIXMIAMI: END

mission_start_hycobuy:

SCRIPT_NAME	hycobuy

flag_player_on_mission = 1
{ // FIXMIAMI: scope moved up, was after WAIT 0

// FIXMIAMI: START
LVAR_INT flag_hycobuy_set1
LVAR_INT flag_hycobuy_set2
LVAR_INT flag_hycobuy_set3
LVAR_INT flag_hycobuy_set4
flag_hycobuy_set1 = 0
flag_hycobuy_set2 = 0
flag_hycobuy_set3 = 0
flag_hycobuy_set4 = 0
// FIXMIAMI: END

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before wait

WAIT 0

	GOSUB hycobuy_set1 // FIXMIAMI: moved stuff into a subroutine

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT hycobuyX hycobuyY hycobuyZ RADAR_SPRITE_SAVEHOUSE hycobuy_blip 
			CHANGE_BLIP_DISPLAY hycobuy_blip BLIP_ONLY
			START_NEW_SCRIPT hycosave1_save_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	GOSUB hycobuy_set2 // FIXMIAMI: moved stuff into a subroutine

	CLEAR_AREA -833.8110 1304.0696 10.5131 1.0 TRUE
	SET_PLAYER_COORDINATES player1 -833.8110 1304.0696 10.5131
	SET_PLAYER_HEADING player1 200.4458
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION -905.0276 1352.5636 50.7682 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -904.0880 1352.2612 50.9287 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	PRINT_WITH_NUMBER_BIG HYCOBUY hycobuy_price 5000 6 //"Hyman Condo purchased: $ 15000"
	GOSUB hycobuy_set3 // FIXMIAMI: moved stuff into a subroutine
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 2000

//	IF NOT IS_PLAYER_PLAYING player1
//		SET_MUSIC_DOES_FADE TRUE
//		TERMINATE_THIS_SCRIPT
//	ENDIF
//
//	SET_FIXED_CAMERA_POSITION -825.6582 1296.7921 12.5176 0.0 0.0 0.0
//	POINT_CAMERA_AT_POINT -826.3120 1297.5386 12.3943 JUMP_CUT

	PRINT_NOW BUYSAVE 3000 1//~g~You can now save your game here for free.

	WAIT 3000

	SET_FIXED_CAMERA_POSITION -848.3207 1292.8352 11.4866 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -847.6996 1293.6107 11.5998 JUMP_CUT

	PRINT_NOW BUYGARS 3000 1//~g~You can also store vehicles in these garages.
	GOSUB hycobuy_set4 // FIXMIAMI: moved stuff into a subroutine

	WAIT 3000

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
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

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	GOSUB get_fading_status

	RETURN // FIXMIAMI

// FIXMIAMI: START

hycobuy_set1:
IF flag_hycobuy_set1 = 0
	REMOVE_BLIP hycobuy_blip
	PLAYER_MADE_PROGRESS 1
	flag_hycobuy_set1 = 1
ENDIF
RETURN

hycobuy_set2:
IF flag_hycobuy_set2 = 0
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT hycobuyX hycobuyY hycobuyZ RADAR_SPRITE_SAVEHOUSE hycobuy_blip 
	CHANGE_BLIP_DISPLAY hycobuy_blip BLIP_ONLY
	START_NEW_SCRIPT hycosave1_save_loop
	flag_hycobuy_set2 = 1
ENDIF
RETURN

hycobuy_set3:
IF flag_hycobuy_set3 = 0
	Hyman_condo_bought = 1
	CREATE_CLOTHES_PICKUP -820.2 1364.1 66.4 1 safehouse_clothes2   
	safehouse_created2 = 1
	ADD_MONEY_SPENT_ON_PROPERTY hycobuy_price
	SET_PROPERTY_AS_OWNED PROP_HYMAN_CONDO
	//hycobuy_price *= -1
	//ADD_SCORE player1 hycobuy_price
	flag_hycobuy_set3 = 1
ENDIF
RETURN

hycobuy_set4:
IF flag_hycobuy_set4 = 0
	CHANGE_GARAGE_TYPE hycobuy_save_garage1 GARAGE_HIDEOUT_TWO 
	CHANGE_GARAGE_TYPE hycobuy_save_garage2 GARAGE_HIDEOUT_THREE 
	CHANGE_GARAGE_TYPE hycobuy_save_garage3 GARAGE_HIDEOUT_FOUR 
	flag_hycobuy_set4 = 1
ENDIF
RETURN

mission_deatharrest_hycobuy:
	GOSUB hycobuy_set1
	GOSUB hycobuy_set2
	GOSUB hycobuy_set3
	GOSUB hycobuy_set4
	RETURN
// FIXMIAMI: END

mission_cleanup_hycobuy: // FIXMIAMI
	SET_MUSIC_DOES_FADE TRUE
					
												
flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: moved up

}
RETURN 

