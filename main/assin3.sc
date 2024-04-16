MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// **********************************    ASSASSIN 3	  **************************************
// **********************************     Autocide	  **************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

{
SCRIPT_NAME assin3

// Mission start stuff

GOSUB mission_start_assin3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_assin3_failed
ENDIF

GOSUB mission_cleanup_assin3

MISSION_END

 
// Variables for mission

VAR_INT firstguy_a3
VAR_FLOAT firstguy_a3x
VAR_FLOAT firstguy_a3y
VAR_FLOAT firstguy_a3z
VAR_FLOAT firstguy_a4heading
VAR_INT firstguyblip playerhasmissed1


VAR_INT secondguy_a3
VAR_FLOAT secondguy_a3x
VAR_FLOAT secondguy_a3y
VAR_FLOAT secondguy_a3z
VAR_FLOAT secondguy_a4heading
VAR_INT secondguyblip
VAR_INT secondguyscar
VAR_INT secondguygotshot secondguyhealth locateplayer2

VAR_INT thirdguy_a3
VAR_FLOAT thirdguy_a3x
VAR_FLOAT thirdguy_a3y
VAR_FLOAT thirdguy_a3z
VAR_FLOAT thirdguy_a4heading
VAR_INT thirdguyblip
VAR_INT thirdguyscar thirdguygotshot thirdguyhealth locateplayer3 

VAR_INT thirdguy2_a3
VAR_INT thirdguy2blip



VAR_INT fourthguy_a3
VAR_FLOAT fourthguy_a3x
VAR_FLOAT fourthguy_a3y
VAR_FLOAT fourthguy_a3z
VAR_FLOAT fourthguy_a4heading
VAR_INT fourthguyblip 
VAR_INT fourthguyscar fourthguygotshot playerhasmissed4 locateplayer4

VAR_INT fifthguy_a3
VAR_FLOAT fifthguy_a3x
VAR_FLOAT fifthguy_a3y
VAR_FLOAT fifthguy_a3z
VAR_FLOAT fifthguy_a4heading
VAR_INT fifthguyblip 
VAR_INT fifthguygotshot everyoneisdead_a3 fifthguyscar locateplayer5 fifthguyhealth

VAR_INT sniper_a3
VAR_FLOAT sniper_a3x
VAR_FLOAT sniper_a3y
VAR_FLOAT sniper_a3z
VAR_INT sniper_a3blip

VAR_INT uzi_a3 motorbike_am3

//flags
VAR_INT gotophoneblip
VAR_INT getfirstguy
VAR_INT getsecondguy
VAR_INT getthirdguy
VAR_INT getfourthguy
VAR_INT getfifthguy got_out_of_car_flag_a3


VAR_INT timer_a3 //mission timer


//car stuck

VAR_FLOAT thirdguyscarx thirdguyscary thirdguyscarz
VAR_FLOAT secondguyscarx secondguyscary secondguyscarz

//flag
VAR_INT thirdguytold


// **************************************** Mission Start **********************************

mission_start_assin3:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1


WAIT 0

LOAD_MISSION_TEXT ASSIN3 
///////////////////////////////////////////////////////////////////////////////////////cutscene

REQUEST_MODEL WMYCW //construction worker - painter
REQUEST_MODEL GDa // security guard
REQUEST_MODEL HMYAP //airport worker
REQUEST_MODEL JMOTO //tourist
REQUEST_MODEL BOBCAT
REQUEST_MODEL tropic
REQUEST_MODEL PCJ600
REQUEST_MODEL securica
REQUEST_MODEL buddyshot
REQUEST_MODEL cellphone

WHILE NOT HAS_MODEL_LOADED WMYCW
   OR NOT HAS_MODEL_LOADED BOBCAT
   OR NOT HAS_MODEL_LOADED tropic
   OR NOT HAS_MODEL_LOADED PCJ600
   OR NOT HAS_MODEL_LOADED buddyshot
   WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED GDa
	OR NOT HAS_MODEL_LOADED securica
	OR NOT HAS_MODEL_LOADED HMYAP
	OR NOT HAS_MODEL_LOADED JMOTO
	OR NOT HAS_MODEL_LOADED cellphone
	WAIT 0
ENDWHILE

LOAD_SPECIAL_CHARACTER 1 MBb

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	WAIT 0
ENDWHILE

SET_PED_DENSITY_MULTIPLIER 0.0
SET_CAR_DENSITY_MULTIPLIER 0.0

CLEAR_AREA 38.396473 -1026.226807 9.660453 4.0 FALSE
CLEAR_AREA_OF_CHARS 14.0 -1034.703 5.02 69.44 -1008.6639 14.0

SWITCH_WIDESCREEN ON		  

SET_PLAYER_COORDINATES player1 38.396473 -1023.987854 9.450843 
SET_PLAYER_HEADING player1 9.008627

SET_FIXED_CAMERA_POSITION 38.396473 -1026.226807 9.660453 0.0 0.0 0.0
POINT_CAMERA_AT_PLAYER player1 FOLLOWPED JUMP_CUT
SET_CAMERA_BEHIND_PLAYER
SET_CHAR_ANSWERING_MOBILE scplayer TRUE

LOAD_MISSION_AUDIO 1 JOB3_1
LOAD_MISSION_AUDIO 2 JOB3_2

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_NOW ( ASM3_C ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm3cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM3_C
CLEAR_MISSION_AUDIO 1

PRINT_NOW ( ASM3_D ) 10000 1 
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm3cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM3_D
CLEAR_MISSION_AUDIO 2

LOAD_MISSION_AUDIO 1 JOB3_3

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 


PRINT_NOW ( ASM3_E ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm3cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM3_E
CLEAR_MISSION_AUDIO 1

endasm3cs:

CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
CLEAR_SMALL_PRINTS

WAIT 500

SET_CHAR_ANSWERING_MOBILE scplayer FALSE
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone

DO_FADE 1000 FADE_OUT


SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0

TIMERA = 0 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SET_PLAYER_CONTROL player1 ON



//////////////////////////////////////////////////////////////////////////////////////



			///////////////////////////////////////////////////////////		VARIABLES		///////////////////////////////////////////////////



//sniper rifle location
sniper_a3x = -42.959793
sniper_a3y = -1049.275269
sniper_a3z = 10.463915

//locations for guys
firstguy_a3x = -52.033546//-50.778889
firstguy_a3y = -885.064392//-890.072876
firstguy_a3z = 26.449224//27.449224
firstguy_a4heading = 278.496242//283.815582

secondguy_a3x = 353.931//344.432373
secondguy_a3y = -729.856//-726.805237
secondguy_a3z = 10.426//9.808237
secondguy_a4heading = 336.07//336.426666

thirdguy_a3x = 406.6844
thirdguy_a3y = 210.52
thirdguy_a3z = 10.79
thirdguy_a4heading = 52.8 

fourthguy_a3x = 36.2//6.575
fourthguy_a3y = -668.4//-700.571
fourthguy_a3z = 4.95
fourthguy_a4heading = 131.2

fifthguy_a3x = 31.4084//408.839
fifthguy_a3y = -1388.6462//-553.487
fifthguy_a3z = 9.2868//9.785
fifthguy_a4heading = 152.6697//337.751

timer_a3 = 540000

//flags values
gotophoneblip = 0
getfirstguy = 0
getsecondguy = 0
getthirdguy = 0
getfourthguy = 0
getfifthguy = 0


locateplayer2 = 0
locateplayer3 = 0
locateplayer4 = 0
locateplayer5 = 0

secondguygotshot = 0
thirdguygotshot = 0
fourthguygotshot = 0
fifthguygotshot = 0
everyoneisdead_a3 = 0

got_out_of_car_flag_a3 = 0
//check if sniper bullet in area
playerhasmissed1 = 0 //ped
playerhasmissed4 = 0 //boat

thirdguytold = 0

SET_ENTER_CAR_RANGE_MULTIPLIER 3.5

		
																						 
missionloopassin3:

WAIT 0

//locate player at phone
IF gotophoneblip = 0
	DISPLAY_ONSCREEN_TIMER_WITH_STRING timer_a3 TIMER_DOWN ( ASM3_11 ) ///change
	gotophoneblip = 1
ENDIF

IF gotophoneblip = 1
	CREATE_PICKUP_WITH_AMMO SNIPER PICKUP_ONCE 12 sniper_a3x sniper_a3y sniper_a3z sniper_a3
	CREATE_PICKUP_WITH_AMMO UZI PICKUP_ONCE 180 -43.075539 -1052.055786 10.471653 uzi_a3 
	ADD_BLIP_FOR_PICKUP sniper_a3 sniper_a3blip
	CHANGE_BLIP_COLOUR sniper_a3blip CYAN
	
	CLEAR_AREA -41.6449 -1039.3809 9.4545 1.5 FALSE
	CREATE_CAR PCJ600 -41.6449 -1039.3809 9.4545 motorbike_am3
	CHANGE_CAR_COLOUR motorbike_am3 CARCOLOUR_WHITE CARCOLOUR_WHITE
	SET_CAR_HEADING motorbike_am3 79.1594
			
	PRINT_NOW ( ASM3_12 ) 8000 2
	TIMERA = 0
	gotophoneblip = 2
ENDIF 

//if been picked up or player not in area remove blip
IF gotophoneblip = 2
	IF HAS_PICKUP_BEEN_COLLECTED sniper_a3
	OR NOT LOCATE_PLAYER_ANY_MEANS_2D player1 sniper_a3x sniper_a3y 130.0 130.0 FALSE 
		REMOVE_BLIP sniper_a3blip
		gotophoneblip = 3
	ENDIF
ENDIF 

//If timer is greater than 10 seconds or if the player has picked up his weapons remove blip
IF getfirstguy = 0
	IF TIMERA > 9999
	OR gotophoneblip = 3
		getfirstguy = 1
	ENDIF
ENDIF


/////////////////////////////////////////////////////////////////////		FIRST GUY THE PAINTER
IF getfirstguy = 1		    
	CLEAR_AREA firstguy_a3x firstguy_a3y firstguy_a3z 1.0 FALSE
	CREATE_CHAR PEDTYPE_CIVMALE WMYCW firstguy_a3x firstguy_a3y firstguy_a3z firstguy_a3

	
	CLEAR_CHAR_THREAT_SEARCH firstguy_a3
	SET_CHAR_HEADING firstguy_a3 firstguy_a4heading	
	ADD_BLIP_FOR_CHAR firstguy_a3 firstguyblip
	SET_CHAR_STAY_IN_SAME_PLACE firstguy_a3 TRUE
	PRINT_NOW ( ASM3_13 ) 8000 2
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 350000
	getfirstguy = 2
ENDIF 

IF NOT IS_CHAR_DEAD firstguy_a3
	IF IS_SNIPER_BULLET_IN_AREA -30.3157 -896.563 17.367552 -55.192 -880.0 37.84 
		playerhasmissed1 = 1
			IF playerhasmissed1 = 1
				SET_CHAR_WAIT_STATE firstguy_a3 WAITSTATE_PLAYANIM_DUCK 60000
				playerhasmissed1 = 2
			ENDIF
	ELSE
		IF playerhasmissed1 = 0
			SET_CHAR_WAIT_STATE firstguy_a3 WAITSTATE_USE_ATM 60000
		ENDIF
	
	ENDIF
ENDIF
			  


IF getfirstguy > 1
	IF getfirstguy < 3
		IF IS_CHAR_DEAD firstguy_a3
			getfirstguy = 3
			getsecondguy = 1
			REMOVE_BLIP firstguyblip
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ENDIF
	ENDIF
ENDIF


/////////////////////////////////////////////////////////////////////	SECOND GUY STATIONARY IN CAR
IF getsecondguy = 1

	MARK_MODEL_AS_NO_LONGER_NEEDED WMYCW 
	MARK_CHAR_AS_NO_LONGER_NEEDED firstguy_a3 
	
	CLEAR_AREA secondguy_a3x secondguy_a3y secondguy_a3z 3.0 FALSE
	CREATE_CAR securica secondguy_a3x secondguy_a3y secondguy_a3z secondguyscar
	SET_CAR_HEADING secondguyscar secondguy_a4heading
	CREATE_CHAR_INSIDE_CAR secondguyscar PEDTYPE_CIVMALE GDa secondguy_a3
    
	CLEAR_CHAR_THREAT_SEARCH secondguy_a3
	CAR_SET_IDLE secondguyscar
	ADD_BLIP_FOR_CHAR secondguy_a3 secondguyblip
	LOCK_CAR_DOORS secondguyscar CARLOCK_LOCKOUT_PLAYER_ONLY
	SET_CAR_HEALTH secondguyscar 2200
	SET_CAR_ONLY_DAMAGED_BY_PLAYER secondguyscar TRUE
	SET_CAR_HEAVY secondguyscar TRUE
	PRINT_NOW ( ASM3_14 ) 8000 2
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	getsecondguy = 2
ENDIF


IF getsecondguy = 2				//counter check if player is near
	IF secondguygotshot = 0
		IF TIMERA > 799
			IF NOT IS_CHAR_DEAD secondguy_a3 
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 secondguy_a3 20.0 20.0 2.0 FALSE
					IF NOT IS_CAR_DEAD secondguyscar
						IF IS_CAR_ON_SCREEN secondguyscar
							IF NOT IS_CHAR_LEAVING_VEHICLE_TO_DIE secondguy_a3 
								PRINT_NOW ( ASM3_18 ) 2000 2
								TIMERA = 0
								locateplayer2++
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF getsecondguy = 2							 //if player is very near with weapon
	IF secondguygotshot = 0
		IF NOT IS_CHAR_DEAD secondguy_a3
			IF IS_CHAR_ON_SCREEN secondguy_a3
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 secondguy_a3 11.0 11.0 2.0 FALSE
					IF IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ANYWEAPON
						IF NOT IS_CAR_DEAD secondguyscar
							IF IS_CAR_ON_SCREEN secondguyscar
								IF NOT IS_CHAR_LEAVING_VEHICLE_TO_DIE secondguy_a3 
									locateplayer2 = 20
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF getsecondguy = 2							 //if player bursts any tyre
	IF secondguygotshot = 0
		IF NOT IS_CAR_DEAD secondguyscar 
			IF IS_CAR_TYRE_BURST secondguyscar ANY_WHEEL
				locateplayer2 = 20
			ENDIF
		ENDIF
	ENDIF
ENDIF



//driving style
IF getsecondguy = 2
	IF secondguygotshot = 0
		IF NOT IS_CAR_DEAD secondguyscar
			GET_CAR_HEALTH secondguyscar secondguyhealth
				IF secondguyhealth < 2200
				OR locateplayer2 > 3
						IF NOT IS_CHAR_DEAD secondguy_a3
							IF NOT IS_CAR_DEAD secondguyscar 
								IF IS_CHAR_IN_CAR secondguy_a3 secondguyscar
									IF NOT IS_CHAR_LEAVING_VEHICLE_TO_DIE secondguy_a3 
										SET_CAR_CRUISE_SPEED secondguyscar 38.0
										CAR_WANDER_RANDOMLY secondguyscar
										SET_CAR_DRIVING_STYLE secondguyscar DRIVINGMODE_PLOUGHTHROUGH
										PRINT_NOW ( ASM3_19 ) 5000 2
										ADD_STUCK_CAR_CHECK secondguyscar 0.5 1000
										ADD_UPSIDEDOWN_CAR_CHECK secondguyscar
										secondguygotshot = 1
									ENDIF
								ENDIF
							ENDIF
						ENDIF
				ENDIF
		ENDIF
	ENDIF 
ENDIF


//stuck checks
IF secondguygotshot = 1
	IF getsecondguy < 3
		IF NOT IS_CHAR_DEAD secondguy_a3
			IF NOT IS_CAR_DEAD secondguyscar
				IF IS_CHAR_IN_CAR secondguy_a3 secondguyscar 
					IF NOT IS_CAR_IN_WATER secondguyscar
						IF NOT IS_CAR_ON_FIRE secondguyscar
							IF IS_CAR_STUCK secondguyscar
							OR IS_CAR_STUCK_ON_ROOF secondguyscar
								IF NOT IS_CAR_ON_SCREEN secondguyscar
									GET_CAR_COORDINATES secondguyscar secondguyscarx secondguyscary secondguyscarz
									GET_CLOSEST_CAR_NODE secondguyscarx secondguyscary secondguyscarz secondguyscarx secondguyscary secondguyscarz
									IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY secondguyscarx secondguyscary secondguyscarz 4.0 4.0 3.0
										IF NOT IS_POINT_ON_SCREEN secondguyscarx secondguyscary secondguyscarz 3.0
											SET_CAR_CRUISE_SPEED secondguyscar 38.0
											CAR_WANDER_RANDOMLY secondguyscar
											SET_CAR_DRIVING_STYLE secondguyscar DRIVINGMODE_PLOUGHTHROUGH
							 			ENDIF
									ENDIF
						 		 ENDIF
						    ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF




//if van becomes damaged guy gets out and legs it
IF secondguygotshot = 1
	IF NOT IS_CHAR_DEAD secondguy_a3
		IF NOT IS_CAR_DEAD secondguyscar
			GET_CAR_HEALTH secondguyscar secondguyhealth
				IF secondguyhealth < 450
					CAR_SET_IDLE secondguyscar 
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS secondguy_a3 player1
					secondguygotshot = 2
				ENDIF
			
		ENDIF
	ENDIF
ENDIF  	  


//move onto next guy
IF getsecondguy > 1
	IF getsecondguy < 3
		IF IS_CHAR_DEAD secondguy_a3
			getsecondguy = 3
			getthirdguy = 1
			REMOVE_BLIP secondguyblip
		ENDIF
	ENDIF
ENDIF


////////////////////////////////////////////////////////////////////// THIRD GUY AT JEWELRY SHOP, 2 guys
IF getthirdguy = 1

	MARK_MODEL_AS_NO_LONGER_NEEDED GDa // security guard
	MARK_CHAR_AS_NO_LONGER_NEEDED secondguy_a3
	MARK_MODEL_AS_NO_LONGER_NEEDED securica
	MARK_CAR_AS_NO_LONGER_NEEDED secondguyscar
	
	CLEAR_AREA thirdguy_a3x thirdguy_a3y thirdguy_a3z 3.0 FALSE
	CREATE_CAR BOBCAT thirdguy_a3x thirdguy_a3y thirdguy_a3z thirdguyscar
	CHANGE_CAR_COLOUR thirdguyscar CARCOLOUR_BLACK CARCOLOUR_RED6
	SET_CAR_HEADING thirdguyscar thirdguy_a4heading
	SET_CAR_HEALTH thirdguyscar 1000
	
	//driver
	CREATE_CHAR_INSIDE_CAR thirdguyscar PEDTYPE_CIVMALE HMYAP thirdguy_a3


	CLEAR_CHAR_THREAT_SEARCH thirdguy_a3
	CAR_SET_IDLE thirdguyscar
	ADD_BLIP_FOR_CHAR thirdguy_a3 thirdguyblip
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER thirdguy_a3 TRUE
	
	//passenger
	CREATE_CHAR_AS_PASSENGER thirdguyscar PEDTYPE_CIVMALE HMYAP 0 thirdguy2_a3 
    
	ADD_BLIP_FOR_CHAR thirdguy2_a3 thirdguy2blip
	GIVE_WEAPON_TO_CHAR thirdguy2_a3 WEAPONTYPE_STUBBY_SHOTGUN 30000
	SET_CHAR_ACCURACY thirdguy2_a3 95
	CLEAR_CHAR_THREAT_SEARCH thirdguy2_a3
	SET_CHAR_THREAT_SEARCH thirdguy2_a3 THREAT_PLAYER1
	SET_CHAR_PERSONALITY thirdguy2_a3 PEDSTAT_TOUGH_GUY
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER thirdguy2_a3 TRUE
	
	LOCK_CAR_DOORS thirdguyscar CARLOCK_LOCKOUT_PLAYER_ONLY
	SET_CAR_ONLY_DAMAGED_BY_PLAYER thirdguyscar TRUE
	PRINT_NOW ( ASM3_15 ) 8000 2
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	getthirdguy = 2
ENDIF

//seen you counter
IF getthirdguy = 2
	IF thirdguygotshot = 0
		IF TIMERA > 799
			IF NOT IS_CHAR_DEAD thirdguy_a3 
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 thirdguy_a3 36.0 36.0 2.0 FALSE
					IF NOT IS_CAR_DEAD thirdguyscar
						IF IS_CAR_ON_SCREEN thirdguyscar
							IF NOT locateplayer3 > 2
								IF NOT IS_CHAR_LEAVING_VEHICLE_TO_DIE thirdguy_a3 
									PRINT_NOW ( ASM3_22 ) 2000 2
									TIMERA = 0
									locateplayer3++
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF getthirdguy = 2							 //if player is very near with weapon
	IF thirdguygotshot = 0
		IF NOT IS_CHAR_DEAD thirdguy_a3
			IF IS_CHAR_ON_SCREEN thirdguy_a3
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 thirdguy_a3 20.0 20.0 2.0 FALSE
					IF IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ANYWEAPON
						locateplayer3 = 20
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF getthirdguy = 2							 //if player bursts any tyre
	IF thirdguygotshot = 0
		IF NOT IS_CAR_DEAD thirdguyscar 
			IF IS_CAR_TYRE_BURST thirdguyscar ANY_WHEEL
				locateplayer3 = 20
			ENDIF
		ENDIF
	ENDIF
ENDIF


//seen player
IF getthirdguy = 2
	IF thirdguygotshot = 0
		IF NOT IS_CAR_DEAD thirdguyscar
			GET_CAR_HEALTH thirdguyscar thirdguyhealth
				IF thirdguyhealth < 1000
				OR locateplayer3 > 2
				OR IS_CHAR_DEAD thirdguy_a3

					PRINT_NOW ( ASM3_20 ) 5000 2
					IF NOT IS_CHAR_DEAD thirdguy2_a3
						SET_CHAR_OBJ_LEAVE_ANY_CAR thirdguy2_a3
					ENDIF 
					thirdguygotshot = 1
				
				ENDIF
		ENDIF
	ENDIF 
ENDIF

//passenger get out and kill player
IF thirdguygotshot = 1
	IF NOT IS_CHAR_DEAD thirdguy2_a3
		IF NOT IS_CHAR_IN_ANY_CAR thirdguy2_a3
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT thirdguy2_a3 player1
			thirdguygotshot = 2
		ENDIF
	ELSE
	   thirdguygotshot = 2	 
	ENDIF
ENDIF

//drive
IF thirdguygotshot = 2
OR IS_CHAR_DEAD thirdguy2_a3
	IF NOT IS_CHAR_DEAD thirdguy_a3
		IF NOT IS_CAR_DEAD thirdguyscar 
			IF IS_CHAR_IN_CAR thirdguy_a3 thirdguyscar
				IF NOT IS_CHAR_LEAVING_VEHICLE_TO_DIE thirdguy_a3
					IF thirdguytold = 0
						PRINT_NOW ( ASM3_20 ) 5000 2
						SET_CAR_CRUISE_SPEED thirdguyscar 34.0
						CAR_WANDER_RANDOMLY thirdguyscar
						SET_CAR_DRIVING_STYLE thirdguyscar DRIVINGMODE_AVOIDCARS
						ADD_STUCK_CAR_CHECK thirdguyscar 0.5 1000
						ADD_UPSIDEDOWN_CAR_CHECK thirdguyscar
						thirdguygotshot = 3
						thirdguytold = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

//get out and kill player
IF thirdguygotshot = 3
	IF NOT IS_CHAR_DEAD thirdguy_a3
		IF NOT IS_CAR_DEAD thirdguyscar
			GET_CAR_HEALTH thirdguyscar thirdguyhealth
				IF thirdguyhealth < 500
					IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 thirdguyscar 40.0 40.0 FALSE
						SET_CAR_MISSION thirdguyscar MISSION_RAMPLAYER_FARAWAY
						thirdguygotshot = 4
					ENDIF
				ENDIF
		ENDIF
	ENDIF
ENDIF 

//stuck checks
IF thirdguygotshot > 2
	IF getthirdguy < 3
		IF NOT IS_CHAR_DEAD thirdguy_a3
			IF NOT IS_CAR_DEAD thirdguyscar
				IF IS_CHAR_IN_CAR thirdguy_a3 thirdguyscar 
					IF NOT IS_CAR_IN_WATER thirdguyscar
						IF NOT IS_CAR_ON_FIRE thirdguyscar
							IF IS_CAR_STUCK thirdguyscar
							OR IS_CAR_STUCK_ON_ROOF thirdguyscar
								IF NOT IS_CAR_ON_SCREEN thirdguyscar
									GET_CAR_COORDINATES thirdguyscar thirdguyscarx thirdguyscary thirdguyscarz
									GET_CLOSEST_CAR_NODE thirdguyscarx thirdguyscary thirdguyscarz thirdguyscarx thirdguyscary thirdguyscarz
									IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY thirdguyscarx thirdguyscary thirdguyscarz 4.0 4.0 3.0
										IF NOT IS_POINT_ON_SCREEN thirdguyscarx thirdguyscary thirdguyscarz 3.0
											SET_CAR_MISSION thirdguyscar MISSION_RAMPLAYER_FARAWAY
											SET_CAR_CRUISE_SPEED thirdguyscar 35.0
										ENDIF
									ENDIF
						 		 ENDIF
						    ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF



//remove blips
IF getthirdguy > 1
	IF getthirdguy < 3

		IF IS_CHAR_DEAD thirdguy_a3
			REMOVE_BLIP thirdguyblip
		ENDIF
		
		IF IS_CHAR_DEAD thirdguy2_a3
			REMOVE_BLIP thirdguy2blip
		ENDIF

	ENDIF
ENDIF

//create next guy
IF getthirdguy > 1
	IF getthirdguy < 3
		IF IS_CHAR_DEAD thirdguy_a3
			IF IS_CHAR_DEAD thirdguy2_a3
				getthirdguy = 3
				REMOVE_BLIP thirdguyblip
				REMOVE_BLIP thirdguy2blip
				getfourthguy = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF




//////////////////////////////////////////////////////////////////////////////////////// FOURTH GUY ON BOAT
IF getfourthguy = 1
	MARK_MODEL_AS_NO_LONGER_NEEDED HMYAP //airport worker
	MARK_MODEL_AS_NO_LONGER_NEEDED BOBCAT
	MARK_MODEL_AS_NO_LONGER_NEEDED buddyshot
	MARK_CHAR_AS_NO_LONGER_NEEDED thirdguy_a3
	MARK_CHAR_AS_NO_LONGER_NEEDED thirdguy2_a3
	MARK_CAR_AS_NO_LONGER_NEEDED thirdguyscar  
	
	CLEAR_AREA fourthguy_a3x fourthguy_a3y fourthguy_a3z 3.0 FALSE
	CREATE_CAR tropic fourthguy_a3x fourthguy_a3y fourthguy_a3z fourthguyscar
	SET_CAR_HEADING fourthguyscar fourthguy_a4heading
	CREATE_CHAR PEDTYPE_CIVMALE JMOTO 50.916 -640.893 8.3173 fourthguy_a3 
    
	ATTACH_CHAR_TO_CAR fourthguy_a3 fourthguyscar 0.0 -4.0 1.2 FACING_FORWARD 360.0	WEAPONTYPE_UNARMED
	
	ADD_BLIP_FOR_CHAR fourthguy_a3 fourthguyblip
	SET_CAR_ONLY_DAMAGED_BY_PLAYER fourthguyscar TRUE
	SET_CHAR_STAY_IN_SAME_PLACE fourthguy_a3 TRUE
	SET_CHAR_WAIT_STATE fourthguy_a3 WAITSTATE_LOOK_ABOUT 800000
	PRINT_NOW ( ASM3_16 ) 8000 2
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	CLEAR_CHAR_THREAT_SEARCH fourthguy_a3
	getfourthguy = 2
ENDIF


IF getfourthguy = 2
	IF fourthguygotshot = 0
		IF TIMERA > 999
			IF NOT IS_CHAR_DEAD fourthguy_a3 
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 fourthguy_a3 30.0 30.0 5.0 FALSE
					IF NOT IS_CAR_DEAD fourthguyscar
						IF IS_CAR_ON_SCREEN fourthguyscar
							PRINT_NOW ( ASM3_18 ) 2000 2
							TIMERA = 0
							locateplayer4++
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD fourthguy_a3
	IF IS_SNIPER_BULLET_IN_AREA 4.66 -711.711 5.474 8.897 -684.8  11.77
		IF playerhasmissed4 = 0
			SET_CHAR_WAIT_STATE fourthguy_a3 WAITSTATE_PLAYANIM_DUCK 600000
			playerhasmissed4 = 2
		ENDIF
	ENDIF
ENDIF


IF getfourthguy = 2
	IF fourthguygotshot = 0
		IF NOT IS_CAR_DEAD fourthguyscar
			IF playerhasmissed4 = 2
				OR locateplayer4 > 10
					IF NOT IS_CHAR_DEAD fourthguy_a3
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 fourthguy_a3 120.0 120.0 FALSE
							SET_CHAR_STAY_IN_SAME_PLACE fourthguy_a3 TRUE
							fourthguygotshot = 1
						ENDIF
					ENDIF
			ENDIF
		ENDIF
	ENDIF 
ENDIF

 
IF getfourthguy > 1
	IF getfourthguy < 3
		IF IS_CHAR_DEAD fourthguy_a3
			getfourthguy = 3
			getfifthguy = 1
			REMOVE_BLIP fourthguyblip
		ENDIF
	ENDIF
ENDIF

//////////////////////////////////////////////////////////////////////////////////////// FIFTH DRIVING ON HIS MOTORBIKE
IF getfifthguy = 1
	MARK_MODEL_AS_NO_LONGER_NEEDED tropic
	MARK_MODEL_AS_NO_LONGER_NEEDED JMOTO //tourist
	MARK_CHAR_AS_NO_LONGER_NEEDED fourthguy_a3
	MARK_CAR_AS_NO_LONGER_NEEDED fourthguyscar 

	CLEAR_AREA fifthguy_a3x fifthguy_a3y fifthguy_a3z 10.0 FALSE
	CREATE_CAR PCJ600 fifthguy_a3x fifthguy_a3y fifthguy_a3z fifthguyscar
	CHANGE_CAR_COLOUR fifthguyscar CARCOLOUR_STRIKINGBLUE CARCOLOUR_STRIKINGBLUE
	SET_CAR_HEADING fifthguyscar fifthguy_a4heading
	CREATE_CHAR_INSIDE_CAR fifthguyscar PEDTYPE_SPECIAL SPECIAL01 fifthguy_a3
    
    
	CLEAR_CHAR_THREAT_SEARCH fifthguy_a3
	ADD_BLIP_FOR_CHAR fifthguy_a3 fifthguyblip
	LOCK_CAR_DOORS fifthguyscar CARLOCK_LOCKED
	SET_CAR_ONLY_DAMAGED_BY_PLAYER fifthguyscar TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER fifthguy_a3 TRUE
	SET_CAR_CRUISE_SPEED fifthguyscar 12.0
	CAR_WANDER_RANDOMLY fifthguyscar
	SET_CAR_DRIVING_STYLE fifthguyscar DRIVINGMODE_SLOWDOWNFORCARS
	SET_CAR_ONLY_DAMAGED_BY_PLAYER fifthguyscar TRUE
	PRINT_NOW ( ASM3_17 ) 8000 2
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	getfifthguy = 2
ENDIF


IF getfifthguy = 2
	IF fifthguygotshot = 0
		IF TIMERA > 999
			IF NOT IS_CHAR_DEAD fifthguy_a3 
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 fifthguy_a3 90.0 90.0 5.0 FALSE
					IF IS_CHAR_ON_SCREEN fifthguy_a3
						PRINT_NOW ( ASM3_18 ) 5000 2
						TIMERA = 0
						locateplayer5++					  
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF



IF getfifthguy = 2							 //if player is very near 
	IF fifthguygotshot = 0
		IF NOT IS_CHAR_DEAD fifthguy_a3
			IF IS_CHAR_ON_SCREEN fifthguy_a3
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 fifthguy_a3 70.0 70.0 5.0 FALSE
				   locateplayer5 = 20
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF



IF getfifthguy = 2
	IF fifthguygotshot = 0
		IF NOT IS_CAR_DEAD fifthguyscar
			GET_CAR_HEALTH fifthguyscar fifthguyhealth
				IF fifthguyhealth < 1000
				OR locateplayer5 > 1
					IF IS_CHAR_IN_ANY_CAR fifthguy_a3
						got_out_of_car_flag_a3 = 1
						fifthguygotshot = 1
						PRINT_NOW ( ASM3_19 ) 5000 2
					ELSE
						got_out_of_car_flag_a3 = 0
						fifthguygotshot = 1
						PRINT_NOW ( ASM3_19 ) 5000 2
					ENDIF
				ENDIF
		ENDIF
	ENDIF 
ENDIF


IF fifthguygotshot = 1
	IF NOT IS_CHAR_DEAD fifthguy_a3
		
		IF got_out_of_car_flag_a3 = 0
			IF NOT IS_CHAR_IN_ANY_CAR fifthguy_a3
			 	IF NOT IS_CAR_DEAD fifthguyscar
			 		IF NOT IS_PLAYER_IN_CAR player1 fifthguyscar
			 			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER fifthguy_a3 fifthguyscar
			 			SET_CHAR_RUNNING fifthguy_a3 TRUE
			 			got_out_of_car_flag_a3 = 1
			 		ELSE
			 			SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS fifthguy_a3 player1
			 		ENDIF
				ELSE
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS fifthguy_a3 player1
				ENDIF
			ENDIF
		ENDIF
		

		IF got_out_of_car_flag_a3 = 1
			IF NOT IS_CAR_DEAD fifthguyscar
				IF IS_CHAR_IN_CAR fifthguy_a3 fifthguyscar
					SET_CAR_CRUISE_SPEED fifthguyscar 42.0
					SET_CAR_DRIVING_STYLE fifthguyscar DRIVINGMODE_AVOIDCARS
					CAR_WANDER_RANDOMLY	fifthguyscar
					got_out_of_car_flag_a3 = 0
			   	ELSE
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS fifthguy_a3 player1
				ENDIF
			ENDIF
		ENDIF

	ENDIF
ENDIF





IF getfifthguy > 1
	IF getfifthguy < 3
		IF IS_CHAR_DEAD fifthguy_a3
			getfifthguy = 3
			everyoneisdead_a3 = 1
			REMOVE_BLIP fifthguyblip
		ENDIF
	ENDIF
ENDIF

/////////////////////////////////////////////////////  MISSION PASS AND FAIL CONDITIONS


//mission pass
IF everyoneisdead_a3 = 1
AND timer_a3 > 0
	GOTO mission_assin3_passed
ENDIF

//mission fail
IF everyoneisdead_a3 = 0
AND timer_a3 < 1
	PRINT_NOW ( ASM3_21 ) 5000 1
	GOTO mission_assin3_failed
ENDIF 

   
GOTO missionloopassin3
 // **************************************** Mission assin3 failed ************************

mission_assin3_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// **************************************** mission assin3 passed ************************

mission_assin3_passed:

flag_assin_mission3_passed = 1
REGISTER_MISSION_PASSED ( JOB_3 )
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 4000
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
//PLAYER_MADE_PROGRESS 1 // SCFIX: remove double progress
ADD_NUMBER_OF_ASSASSINATIONS 1
REMOVE_BLIP assasin_contact_blip
RETURN
		


// ********************************** mission cleanup **************************************

mission_cleanup_assin3:

flag_player_on_mission = 0

REMOVE_PICKUP sniper_a3
REMOVE_PICKUP uzi_a3

REMOVE_BLIP firstguyblip
REMOVE_BLIP secondguyblip
REMOVE_BLIP thirdguyblip
REMOVE_BLIP thirdguy2blip
REMOVE_BLIP fourthguyblip
REMOVE_BLIP fifthguyblip
REMOVE_BLIP sniper_a3blip
REMOVE_CHAR_ELEGANTLY fifthguy_a3

MARK_MODEL_AS_NO_LONGER_NEEDED tropic
MARK_MODEL_AS_NO_LONGER_NEEDED PCJ600
MARK_MODEL_AS_NO_LONGER_NEEDED WMYCW
MARK_MODEL_AS_NO_LONGER_NEEDED GDa // security guard
MARK_MODEL_AS_NO_LONGER_NEEDED HMYAP //airport worker
MARK_MODEL_AS_NO_LONGER_NEEDED JMOTO //tourist
MARK_MODEL_AS_NO_LONGER_NEEDED BOBCAT
MARK_MODEL_AS_NO_LONGER_NEEDED securica
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
MARK_MODEL_AS_NO_LONGER_NEEDED buddyshot

UNLOAD_SPECIAL_CHARACTER 1
CLEAR_ONSCREEN_TIMER timer_a3
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

 
}