MISSION_START
// *****************************************************************************************
// *****************************************Phil Cassidy 2**********************************
// *****************************************Drink Driving***********************************
// *****************************************Drive Phil to the hospital while drunk**********
// *****************************************************************************************
SCRIPT_NAME phil2
// Mission start stuff
GOSUB mission_start_phil2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_phil2
ENDIF
GOSUB mission_cleanup_phil2
MISSION_END
{ 
// Variables for mission
//people, cars and objects
VAR_INT phil2_car 
VAR_INT phil_noarm
VAR_INT traffic_cops
VAR_INT phils_m60
VAR_INT phils_rocketla
VAR_INT phils_flame
VAR_INT phils_bomb

//blips
VAR_INT radar_blip_phil2_car
VAR_INT radar_blip_hospital1 
VAR_INT radar_blip_hospital2 

//flags
VAR_INT phil2_goals
VAR_INT flag_player_not_in_phil2_car 
VAR_INT flag_phil2_car_upsidedown
VAR_INT rnd_timescale
VAR_INT	phil2_car_health 
VAR_INT phil2_total_car_health
VAR_INT phil2_car_health2
VAR_INT phil2_car_health_diff
VAR_INT drunkeness
VAR_INT motion_blur
VAR_INT phil_speech
VAR_INT at_hospital

//coordinates
VAR_FLOAT area_plyrx1  
VAR_FLOAT area_plyry1  
VAR_FLOAT area_plyrx2  
VAR_FLOAT area_plyry2 
VAR_FLOAT phil_car_speed
VAR_FLOAT car_heading

//cutscene
VAR_INT cs_philbmb
 
// ****************************************Mission Start************************************
mission_start_phil2:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PHIL2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1004.5 311.1 9.9 155.7
// *****************************************Set Flags/variables************************************
phil2_goals = 0
flag_player_not_in_phil2_car = 0
flag_phil2_car_upsidedown = 0
rnd_timescale = 0
phil2_car_health = 0
phil2_total_car_health = 100
phil2_car_health2 = 0
phil2_car_health_diff = 0
drunkeness = 8
motion_blur = 255
phil_speech = 0
at_hospital = 0

player_x = 0.0
player_y = 0.0
player_z = 0.0
area_plyrx1 = 0.0 
area_plyry1 = 0.0 
area_plyrx2 = 0.0 								   
area_plyry2 = 0.0
phil_car_speed = 0.0 
car_heading = 0.0
// ****************************************START OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSphil

LOAD_SPECIAL_MODEL CUTOBJ01 philbmb

LOAD_SCENE -1099.62 327.21 10.23

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0
ENDWHILE

CLEAR_AREA -1083.1 321.1 11.2 300.0 TRUE

LOAD_CUTSCENE phil_2
SET_CUTSCENE_OFFSET -1099.62 327.21 10.23
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_phil
SET_CUTSCENE_ANIM cs_phil CSphil

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_philbmb
SET_CUTSCENE_ANIM cs_philbmb philbmb 

CLEAR_AREA -1105.0 334.0 10.8 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1105.0 334.0 10.8
SET_PLAYER_HEADING player1 265.8

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1073  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW PHIL2_A 10000 1 // Hey Phil, how's it goin?

WHILE cs_time < 2713
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_B 10000 1 // Heeyyyy, Tommy. Howyadoin'? Ish been too long...

WHILE cs_time < 8842
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_C 10000 1 // I swear you should lay off that boom shine,

WHILE cs_time < 10547
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_D 10000 1 // man it smells like paint stripper. Making my eyes burn...

WHILE cs_time < 13397
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_E 10000 1 // Shshs shhh youshelf Tommy,

WHILE cs_time < 16619
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_F 10000 1 // and come over here because there's someshin' I wanna show you.. someshin.

WHILE cs_time < 20734
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_G 10000 1 // Should I be able to smell that from way over here? I'm feeling woozy.

WHILE cs_time < 24299
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_H 10000 1 // Don'tchaworry about the shmell Tommy, you jush wash thish.

WHILE cs_time < 32636
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_I 10000 1 // Shittycheapbatteriesh or shumin'. There'sh shum more on the bench.
  
WHILE cs_time < 44824
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_J 10000 1 // TA-DAAA!

WHILE cs_time < 46000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED 
	ADD_EXPLOSION -1083.8 352.7 11.3 EXPLOSION_ROCKET      
	ADD_EXPLOSION -1083.8 352.7 11.3 EXPLOSION_HELI_BOMB  
	ADD_EXPLOSION -1083.8 352.7 11.3 EXPLOSION_HELI
ENDIF

WHILE cs_time < 48307
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL2_K 10000 1 //Aww Damn!

IF NOT WAS_CUTSCENE_SKIPPED
	IF NOT IS_GERMAN_GAME
	AND NOT IS_FRENCH_GAME
		GOSUB bloody_nuts
		GOSUB bloody_nuts
		GOSUB bloody_nuts
	ENDIF
ENDIF

WHILE cs_time < 48807
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	IF NOT IS_GERMAN_GAME
	AND NOT IS_FRENCH_GAME
		GOSUB bloody_nuts
		GOSUB bloody_nuts
		GOSUB bloody_nuts
	ENDIF
ENDIF

WHILE cs_time < 49307
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 49907
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	IF NOT IS_GERMAN_GAME
	AND NOT IS_FRENCH_GAME
		GOSUB bloody_nuts
		GOSUB bloody_nuts
		GOSUB bloody_nuts
	ENDIF
ENDIF

WHILE cs_time < 50007
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	IF NOT IS_GERMAN_GAME
	AND NOT IS_FRENCH_GAME
		GOSUB bloody_nuts
		GOSUB bloody_nuts
		GOSUB bloody_nuts
	ENDIF
ENDIF

WHILE cs_time < 51007
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	IF NOT IS_GERMAN_GAME
	AND NOT IS_FRENCH_GAME
		GOSUB bloody_nuts
		GOSUB bloody_nuts
		GOSUB bloody_nuts
	ENDIF
ENDIF

WHILE cs_time < 52207
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	IF NOT IS_GERMAN_GAME
	AND NOT IS_FRENCH_GAME
		GOSUB bloody_nuts
		GOSUB bloody_nuts
		GOSUB bloody_nuts
	ENDIF
ENDIF

CLEAR_PRINTS

WHILE cs_time < 53376
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
SET_CAMERA_BEHIND_PLAYER
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

REQUEST_MODEL patriot

WHILE NOT HAS_MODEL_LOADED patriot 
	WAIT 0
ENDWHILE

LOAD_MISSION_AUDIO 2 PHIL2_1
WHILE NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

//cheating the compilier into thinking i have created something which i havent (so it can be used later)
GOTO phil2_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	ADD_BLIP_FOR_COORD -1183.0 -664.2 10.5 radar_blip_hospital2
phil2_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check

LOAD_SPECIAL_CHARACTER 1 IGPhil2
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	WAIT 0
ENDWHILE

//creating car and phil
CREATE_CAR patriot -1097.0 334.0 10.8 phil2_car 
SET_CAR_PROOFS phil2_car FALSE TRUE FALSE FALSE FALSE // SCFIX: make fireproof
SET_CAR_HEADING phil2_car 269.2
WARP_PLAYER_INTO_CAR player1 phil2_car 
SET_CAMERA_BEHIND_PLAYER 

CREATE_CHAR_AS_PASSENGER phil2_car PEDTYPE_CIVMALE SPECIAL01 0 phil_noarm
SET_CHAR_AS_PLAYER_FRIEND phil_noarm player1 TRUE
SET_DRUNK_INPUT_DELAY player1 drunkeness
SET_PLAYER_DRUNKENNESS player1 255
IF NOT IS_GERMAN_GAME
AND NOT IS_FRENCH_GAME
	SET_CHAR_BLEEDING phil_noarm TRUE 
ENDIF
SET_CHAR_CANT_BE_DRAGGED_OUT phil_noarm TRUE 
SET_CHAR_STAY_IN_CAR_WHEN_JACKED phil_noarm TRUE

SET_TIME_SCALE 0.99999999

ADD_BLIP_FOR_COORD -871.6 -469.5 9.9 radar_blip_hospital1

DISPLAY_ONSCREEN_COUNTER_WITH_STRING phil2_total_car_health COUNTER_DISPLAY_BAR (PHI2_04)

GET_CAR_HEALTH phil2_car phil2_car_health2
phil2_car_health2 /= 10

timera = 0
timerb = 0
DO_FADE 1500 FADE_IN
PRINT_NOW ( PHI2_01 ) 5000 1 //Quick, get Phil to the hospital.

drunken_loop:///////////////////////////////////////////////////////////////////////
WAIT 0

IF NOT IS_CAR_DEAD phil2_car
//phil speech
	
	IF IS_PLAYER_IN_CAR player1 phil2_car 
		IF at_hospital = 0
			IF phil_speech = 0
				IF phil2_total_car_health < 85
					LOAD_MISSION_AUDIO 1 PHIL2_4
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE 

					PRINT_NOW PHI2_08 5000 1//Watchout! Charlie in the tree line!
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PHI2_08
					phil_speech = 1 
				ENDIF
			ENDIF

			IF phil_speech = 1
				IF phil2_total_car_health < 75
					LOAD_MISSION_AUDIO 1 PHIL2_5
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE 

					PRINT_NOW PHI2_09 5000 1//Is it me or are the roads made of jelly?
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PHI2_09
					phil_speech = 2 
				ENDIF
			ENDIF

			IF phil_speech = 2
				IF phil2_total_car_health < 65
					LOAD_MISSION_AUDIO 1 PHIL2_6
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE 

					PRINT_NOW PHI2_10 5000 1//Broken Spoon to Mother Hen, you copy?
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PHI2_10
					phil_speech = 3 
				ENDIF
			ENDIF

			IF phil_speech = 3
				IF phil2_total_car_health < 55
					LOAD_MISSION_AUDIO 1 PHIL2_7
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE 

					PRINT_NOW PHI2_11 5000 1//Spooney Wooney Woo Woo Woooo!
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PHI2_11
					phil_speech = 4 
				ENDIF
			ENDIF


			IF phil_speech = 4
				IF phil2_total_car_health < 45
					LOAD_MISSION_AUDIO 1 PHIL2_8
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE 

					PRINT_NOW PHI2_12 5000 1//He's come for me boy!
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PHI2_12
					phil_speech = 5 
				ENDIF
			ENDIF

			IF phil_speech = 5
				IF phil2_total_car_health < 35
					LOAD_MISSION_AUDIO 1 PHIL2_9
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE 

					PRINT_NOW PHI2_13 5000 1//Black feathered wings beating all around...
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PHI2_13
					phil_speech = 6 
				ENDIF
			ENDIF

			IF phil_speech = 6
				IF phil2_total_car_health < 25
					LOAD_MISSION_AUDIO 1 PHIL210
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE 

					PRINT_NOW PHI2_14 5000 1//It ... it's beautiful, man ... beautiful ... but so cold ...
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
						IF phil2_goals = 0
							DRAW_SPHERE -871.6 -469.5 9.9 7.0
						ELSE
							DRAW_SPHERE -1183.0 -664.2 10.5 7.0
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PHI2_14
					phil_speech = 7 
				ENDIF
			ENDIF
		ELSE
			CLEAR_MISSION_AUDIO 1
		ENDIF
	ENDIF
ENDIF
	
IF NOT IS_CAR_DEAD phil2_car
//checking player1 is in car
	IF IS_CAR_UPSIDEDOWN phil2_car
	AND IS_CAR_STOPPED phil2_car
		flag_phil2_car_upsidedown = 1
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player1 phil2_car
	AND flag_player_not_in_phil2_car = 0
	AND flag_phil2_car_upsidedown = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR phil2_car radar_blip_phil2_car
		REMOVE_BLIP radar_blip_hospital1
		REMOVE_BLIP radar_blip_hospital2
		flag_player_not_in_phil2_car = 1 
	ENDIF

	IF IS_PLAYER_IN_CAR player1 phil2_car
	AND flag_player_not_in_phil2_car = 1
		REMOVE_BLIP radar_blip_phil2_car
		REMOVE_BLIP radar_blip_hospital1
		REMOVE_BLIP radar_blip_hospital2
		IF phil2_goals = 0
			ADD_BLIP_FOR_COORD -871.6 -469.5 9.9 radar_blip_hospital1
		ENDIF
		IF phil2_goals = 1
			ADD_BLIP_FOR_COORD -1183.0 -664.2 10.5 radar_blip_hospital2
		ENDIF
		CLEAR_PRINTS
		flag_player_not_in_phil2_car = 0
	ENDIF

//reducing phils life-o-meter(TM) each time the car is hit

	GET_CAR_HEALTH phil2_car phil2_car_health
	phil2_car_health /= 10
	IF phil2_car_health2 > phil2_car_health
		phil2_car_health_diff = phil2_car_health2 - phil2_car_health
		phil2_total_car_health = phil2_total_car_health - phil2_car_health_diff
	ENDIF
	phil2_car_health2 = phil2_car_health	 

//reducing phils life-o-meter(TM) with every second that passes

	IF timera > 1000
		phil2_total_car_health = phil2_total_car_health - 1
		timera = 0
	ENDIF
	
	IF phil2_total_car_health < 1
		IF NOT IS_CHAR_DEAD phil_noarm 
			EXPLODE_CHAR_HEAD phil_noarm
		ENDIF 
		PRINT_NOW ( PHI2_03 ) 5000 1 //Phil Cassidy is dead!!!  Now who's gonna supply arms in Liberty?
		GOTO mission_failed_phil2
	ENDIF	

//reducing drunkeness
	
	IF timerb > 20000
		drunkeness = drunkeness - 1
		motion_blur = motion_blur - 30  //what normal motion blur? 255-normal motion blur / 8 = the figure to replace 30 
		
		SET_DRUNK_INPUT_DELAY player1 drunkeness
		SET_PLAYER_DRUNKENNESS player1 motion_blur

		timerb = 0
	ENDIF
	

//cop level rises if player1 goes past a cop while drunk driving
	GET_CAR_SPEED phil2_car phil_car_speed 
	IF phil_car_speed > 5.0 
		IF NOT IS_WANTED_LEVEL_GREATER player1 0 
			GET_PLAYER_COORDINATES player1 player_x player_y player_z 

			area_plyrx1 = player_x + 10.0 
			area_plyry1 = player_y + 10.0 
			area_plyrx2 = player_x - 10.0 
			area_plyry2 = player_y - 10.0 

			GET_RANDOM_COP_IN_AREA area_plyrx1 area_plyry1 area_plyrx2 area_plyry2 1 0 0 0 0 traffic_cops  
			
			IF NOT traffic_cops = -1
				ALTER_WANTED_LEVEL player1 1 

				LOAD_MISSION_AUDIO 1 PHIL211
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
					IF phil2_goals = 0
						DRAW_SPHERE -871.6 -469.5 9.9 7.0
					ELSE
						DRAW_SPHERE -1183.0 -664.2 10.5 7.0
					ENDIF
				ENDWHILE 

				PRINT_NOW PHI2_15 5000 1//10-4 we've got a drunk driver.
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD phil_noarm
					WAIT 0
					IF phil2_goals = 0
						DRAW_SPHERE -871.6 -469.5 9.9 7.0
					ELSE
						DRAW_SPHERE -1183.0 -664.2 10.5 7.0
					ENDIF
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT PHI2_15
			ENDIF
			MARK_CHAR_AS_NO_LONGER_NEEDED traffic_cops

		ENDIF
	ENDIF

//blood spurting out of window
	/*
	GENERATE_RANDOM_INT_IN_RANGE 0 11 rnd_timescale
	IF rnd_timescale = 3	
		GET_OFFSET_FROM_CAR_IN_WORLD_COORDS phil2_car 2.0 0.0 0.0 player_x player_y player_z
		GET_OFFSET_FROM_CAR_IN_WORLD_COORDS phil2_car 3.0 0.0 0.0 dildo_check1x dildo_check1y dildo_check1z
		CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z dildo_check1x dildo_check1y dildo_check1z 0.0
		CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z dildo_check1x dildo_check1y dildo_check1z 0.0
		CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z dildo_check1x dildo_check1y dildo_check1z 0.0
		CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z dildo_check1x dildo_check1y dildo_check1z 0.0
		CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z dildo_check1x dildo_check1y dildo_check1z 0.0
		CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z dildo_check1x dildo_check1y dildo_check1z 0.0
		CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z dildo_check1x dildo_check1y dildo_check1z 0.0
		CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z dildo_check1x dildo_check1y dildo_check1z 0.0
	ENDIF   
	*/

//when player1 reaches hospital, phil tells him to go to a dodgy chop shop elsewhere

	IF phil2_goals = 0
		IF NOT IS_CAR_DEAD phil2_car
			IF IS_PLAYER_IN_CAR player1 phil2_car  
				IF LOCATE_STOPPED_CAR_3D phil2_car -871.6 -469.5 9.9 7.0 7.0 7.0 TRUE
					REMOVE_BLIP radar_blip_hospital1
					ADD_BLIP_FOR_COORD -1183.0 -664.2 10.5 radar_blip_hospital2
					at_hospital = 1
					PRINT_NOW PHI2_05 5000 1//Not the hospital, man! Too many cops and Viet Cong!
					PLAY_MISSION_AUDIO 2
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
					ENDWHILE
					CLEAR_MISSION_AUDIO 2
					CLEAR_THIS_PRINT PHI2_05


					LOAD_MISSION_AUDIO 2 PHIL2_2
					WHILE NOT HAS_MISSION_AUDIO_LOADED 2
						WAIT 0
					ENDWHILE 
					PRINT_NOW PHI2_06 5000 1//There's an ex-army surgeon owes me a few favours and a lawnmower.
					PLAY_MISSION_AUDIO 2
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
					ENDWHILE
					CLEAR_MISSION_AUDIO 2
					CLEAR_THIS_PRINT PHI2_06

				
					LOAD_MISSION_AUDIO 2 PHIL2_3
					WHILE NOT HAS_MISSION_AUDIO_LOADED 2
						WAIT 0
					ENDWHILE 
					PRINT_NOW PHI2_07 5000 1//He's got a place down Little Havana, ooo look, a giant fish.
					PLAY_MISSION_AUDIO 2
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD phil_noarm
						WAIT 0
					ENDWHILE
					CLEAR_MISSION_AUDIO 2
					CLEAR_THIS_PRINT PHI2_07
					at_hospital = 0
					phil2_goals = 1				
				ENDIF
			ENDIF
		ENDIF
	ENDIF 

	IF phil2_goals = 1
		IF NOT IS_CAR_DEAD phil2_car 
			IF IS_PLAYER_IN_CAR player1 phil2_car  
	 			IF LOCATE_STOPPED_CAR_3D phil2_car -1183.0 -664.2 10.5 7.0 7.0 7.0 TRUE
	// ******************************************START OF PHIL GETTING OUT OF CAR CUTSCENE********************************
					SET_PLAYER_CONTROL player1 OFF
					SWITCH_WIDESCREEN ON
					SET_PLAYER_DRUNKENNESS player1 0

					IF NOT IS_CHAR_DEAD phil_noarm
						GET_CAR_HEADING phil2_car car_heading
						SET_CAR_COORDINATES phil2_car -1183.0 -664.2 10.5
						SET_CAR_HEADING phil2_car car_heading 
						SET_CHAR_OBJ_LEAVE_ANY_CAR phil_noarm 
						SET_ANIM_GROUP_FOR_CHAR phil_noarm ANIM_OLD_WOMANPED
					ENDIF
			
					SET_FIXED_CAMERA_POSITION -1178.1 -676.3 15.5 0.0 0.0 0.0 
					POINT_CAMERA_AT_POINT -1183.7 -656.7 11.1 JUMP_CUT

					CLEAR_AREA_OF_CARS -1190.0 -671.2 17.5 -1174.0 -657.2 3.5
				
					IF NOT IS_CHAR_DEAD phil_noarm
						SET_CHAR_OBJ_NO_OBJ phil_noarm 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT phil_noarm -1218.9 -665.1
					ENDIF
					timera = 0
					timerb = 0

					phil_out_car:
					WAIT 0 
					IF timerb > 500
						IF NOT IS_CHAR_DEAD phil_noarm 
							IF NOT IS_GERMAN_GAME
							AND NOT IS_FRENCH_GAME
								GOSUB splurt
							ENDIF
						ENDIF
						timerb = 0
					ENDIF
									
					IF timera > 2000
						timera = 0
						timerb = 0
						GOTO phil_run
					ENDIF
					GOTO phil_out_car
					    
					phil_run:
					WAIT 0

					IF NOT IS_CHAR_DEAD phil_noarm
						IF timerb > 500
							IF NOT IS_CHAR_DEAD phil_noarm 
								IF NOT IS_GERMAN_GAME
								AND NOT IS_FRENCH_GAME
									GOSUB splurt
								ENDIF
							ENDIF
							timerb = 0
						ENDIF
						IF LOCATE_CHAR_ON_FOOT_2D phil_noarm -1218.9 -665.1 3.0 3.0 FALSE
						OR timera > 3000
							GOTO phil_cut
						ENDIF
					ENDIF
					GOTO phil_run 

				   	phil_cut:
					IF NOT IS_CHAR_DEAD phil_noarm
						SET_CHAR_OBJ_NO_OBJ phil_noarm 
						SET_CHAR_COORDINATES phil_noarm -1191.7 -664.3 10.5  
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT phil_noarm -1218.9 -665.1
					ENDIF
					timera = 0
					timerb = 0
					
					SET_FIXED_CAMERA_POSITION -1174.3 -664.2 15.9 0.0 0.0 0.0 
					POINT_CAMERA_AT_POINT -1184.5 -664.1 11.64 JUMP_CUT

					phil_last_walk:
					WAIT 0
					IF NOT IS_CHAR_DEAD phil_noarm
						IF timerb > 500
							IF NOT IS_CHAR_DEAD phil_noarm 
								IF NOT IS_GERMAN_GAME
								AND NOT IS_FRENCH_GAME
									GOSUB splurt
								ENDIF
							ENDIF
							timerb = 0
						ENDIF
						IF LOCATE_CHAR_ON_FOOT_2D phil_noarm -1218.9 -665.1 3.0 3.0 FALSE
						OR timera > 3000
							GOTO phil_finished
						ENDIF
					ENDIF
					GOTO phil_last_walk 
				
					phil_finished:
					SET_TIME_SCALE 1.0
	// ******************************************END OF PHIL GETTING OUT OF CAR CUTSCENE**********************************
					
	// ******************************************START OF ASSET AQUIRED CUTSCENE********************************
					DO_FADE 500 FADE_OUT
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					DELETE_CHAR phil_noarm 
					CREATE_PICKUP M60 PICKUP_IN_SHOP -1105.9 335.3 11.1 phils_m60
					CREATE_PICKUP rocketla PICKUP_IN_SHOP -1105.9 330.3 11.1 phils_rocketla
					CREATE_PICKUP minigun PICKUP_IN_SHOP -1105.9 325.3 11.1 phils_flame
					CREATE_PICKUP bomb PICKUP_IN_SHOP -1105.9 320.3 11.1 phils_bomb

					LOAD_SCENE -1038.4 309.7 20.9
					SET_FIXED_CAMERA_POSITION -1038.4 309.7 20.9 0.0 0.0 0.0 
					POINT_CAMERA_AT_POINT -1065.6 322.1 21.7 JUMP_CUT

					DO_FADE 500 FADE_IN
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
				
					PLAY_MISSION_PASSED_TUNE 1
					PRINT_BIG PHI_AS1 5000 6 //PHILS PLACE ASSET COMPLETED
					
					WAIT 5000
					LOAD_SCENE -1093.2 345.0 14.3
					SET_FIXED_CAMERA_POSITION -1093.2 345.0 14.3 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -1110.1 331.3 11.0 JUMP_CUT
					
					PRINT_NOW PHI_AS2 6000 1//New Weapons available to purchase from Phils Place.

					WAIT 6000
					DO_FADE 500 FADE_OUT
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					GET_PLAYER_COORDINATES player1 player_x player_y player_z
					LOAD_SCENE player_x player_y player_z

					DO_FADE 500 FADE_IN
					
					RESTORE_CAMERA_JUMPCUT
					SET_PLAYER_CONTROL player1 ON
					SWITCH_WIDESCREEN OFF
					SET_PLAYER_DRUNKENNESS player1 motion_blur
	// ******************************************END OF ASSET AQUIRED CUTSCENE********************************
					GOTO mission_passed_phil2
				ENDIF
			ENDIF
		ELSE
			PRINT_NOW ( PHI2_03 ) 5000 1 //Phil Cassidy is dead!!!  Now who's gonna supply arms in Liberty?
			GOTO mission_failed_phil2
		ENDIF
	ENDIF 
ELSE
	PRINT_NOW ( PHI2_03 ) 5000 1 //Phil Cassidy is dead!!!  Now who's gonna supply arms in Liberty?
	GOTO mission_failed_phil2
ENDIF

IF IS_CHAR_DEAD phil_noarm 
	PRINT_NOW ( PHI2_03 ) 5000 1 //Phil Cassidy is dead!!!  Now who's gonna supply arms in Liberty?
	GOTO mission_failed_phil2
ENDIF

GOTO drunken_loop////////////////////////////////////////////////////////////////////////

// Mission failed
mission_failed_phil2:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_phil2:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 4000
PLAYER_MADE_PROGRESS 1 
REGISTER_MISSION_PASSED PHIL_2
REMOVE_BLIP phil_contact_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD philX philY philZ the_phil_blip phil_contact_blip
flag_phil_mission2_passed = 1
RETURN
		

	   
// mission cleanup
mission_cleanup_phil2:
// SCFIX: START
IF NOT IS_CAR_DEAD phil2_car
	SET_CAR_PROOFS phil2_car FALSE FALSE FALSE FALSE FALSE
ENDIF
// SCFIX: END
flag_player_on_mission = 0
SET_PLAYER_CONTROL player1 on
MARK_MODEL_AS_NO_LONGER_NEEDED patriot
MARK_CHAR_AS_NO_LONGER_NEEDED traffic_cops
SHAKE_CAM 0
REMOVE_CHAR_ELEGANTLY phil_noarm 
UNLOAD_SPECIAL_CHARACTER 1 
REMOVE_BLIP radar_blip_phil2_car
REMOVE_BLIP radar_blip_hospital1
REMOVE_BLIP radar_blip_hospital2
CLEAR_ONSCREEN_COUNTER phil2_total_car_health
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN





///////////////////////////////////////////////////////////////////////////////////
bloody_nuts:///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
IF NOT IS_BUTTON_PRESSED PAD1 CROSS
	GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS cs_phil 0.3 0.3 0.3 player_x player_y player_z 
	CREATE_SINGLE_PARTICLE PARTICLE_TEST player_x player_y player_z 0.0 0.0 0.0 0.1
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0

	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 1.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 1.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 1.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 1.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 1.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 1.0 0.03 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 1.0 0.03 0.0

    CREATE_SINGLE_PARTICLE PARTICLE_BLOODDROP player_x player_y player_z 0.0 0.0 0.03 0.0
    CREATE_SINGLE_PARTICLE PARTICLE_BLOODDROP player_x player_y player_z 0.0 0.0 0.03 0.0
    CREATE_SINGLE_PARTICLE PARTICLE_BLOODDROP player_x player_y player_z 0.0 0.0 0.03 0.0
    CREATE_SINGLE_PARTICLE PARTICLE_BLOODDROP player_x player_y player_z 0.0 0.0 0.03 0.0
    CREATE_SINGLE_PARTICLE PARTICLE_BLOODDROP player_x player_y player_z 0.0 0.0 0.03 0.0
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
splurt:////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS phil_noarm -0.3 0.3 0.3 player_x player_y player_z 
CREATE_SINGLE_PARTICLE PARTICLE_TEST player_x player_y player_z 0.0 0.0 0.0 0.1
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL player_x player_y player_z 0.0 0.0 0.03 0.0

CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 0.1 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 0.1 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 0.1 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 0.1 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 0.1 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 0.1 0.03 0.0
CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SPURT player_x player_y player_z 0.0 0.1 0.03 0.0
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////









}		



