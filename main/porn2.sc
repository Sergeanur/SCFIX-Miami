MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Porn 2******************************************
// *****************************************DilDodo*****************************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME porno2
// Mission start stuff
GOSUB mission_start_porn2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_porn2
ENDIF
GOSUB mission_cleanup_porn2
MISSION_END
{ 
// Variables for mission
//people, cars and objects
VAR_INT dildodo

//blips
VAR_INT blip_dildodo
VAR_INT dildocheck_blip1
VAR_INT dildocheck_blip2
VAR_INT dildocheck_blip3
VAR_INT dildocheck_blip4
VAR_INT dildocheck_blip5
VAR_INT dildocheck_blip6

//flags
VAR_INT dildo_check_counter 
VAR_INT dildo1
VAR_INT dildo2
VAR_INT dildo3
VAR_INT dildo4
VAR_INT dildo5
VAR_INT dildo6
VAR_INT particle_effect_ok
VAR_INT dildo_fuel
VAR_INT flag_player_not_in_dildodo
VAR_INT flag_dildodo_upsidedown
VAR_INT random_flyers
VAR_INT plane_help_done
VAR_INT p2game_time_flag
VAR_INT	p2game_timer_start
VAR_INT	p2cop_time_limit
VAR_INT	p2copcar_timer
VAR_INT	p2game_time_present
VAR_INT	p2game_time_difference
VAR_INT	p2timer_in_secs
VAR_INT	p2in_copcar_nice_timer
VAR_INT p2game_timer



//coordinates
VAR_FLOAT dildo_check1x  
VAR_FLOAT dildo_check1y  
VAR_FLOAT dildo_check1z  	 
VAR_FLOAT dildo_check2x  
VAR_FLOAT dildo_check2y  
VAR_FLOAT dildo_check2z  
VAR_FLOAT dildo_check3x  
VAR_FLOAT dildo_check3y  
VAR_FLOAT dildo_check3z  
VAR_FLOAT dildo_check4x  
VAR_FLOAT dildo_check4y  
VAR_FLOAT dildo_check4z  
VAR_FLOAT dildo_check5x  
VAR_FLOAT dildo_check5y  
VAR_FLOAT dildo_check5z 
VAR_FLOAT dildo_check6x  
VAR_FLOAT dildo_check6y  
VAR_FLOAT dildo_check6z 

//cutscene
VAR_INT cc_scenery

// ****************************************Mission Start************************************
mission_start_porn2:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PORN2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 21.489 966.28 9.5 172.7
// *****************************************Set Flags/variables************************************
dildo_check_counter = 6
dildo1 = 0
dildo2 = 0
dildo3 = 0
dildo4 = 0
dildo5 = 0
dildo6 = 0
particle_effect_ok = 0
dildo_fuel = 100 
flag_player_not_in_dildodo = 0
flag_dildodo_upsidedown = 0
random_flyers = 0

//docks > icecream factory
dildo_check1x = -703.0 
dildo_check1y = -1496.0
dildo_check1z = 45.0	 

//Howling Petes > outside g-spotlight
dildo_check2x = -601.0
dildo_check2y = 660.0
dildo_check2z = 44.0

//Dirt track > between tall buildings
dildo_check3x = -464.2
dildo_check3y = 1459.3
dildo_check3z = 40.0

//Rock City > pizza hut outside haitian base
dildo_check4x = -872.8
dildo_check4y = 805.8
dildo_check4z = 35.0

//Printing works > Airport 
dildo_check5x = -1130.2 
dildo_check5y = -182.7
dildo_check5z = 36.0

//bank > between tall buildings 
dildo_check6x = -867.4 
dildo_check6y = -343.2
dildo_check6z = 40.0

player_x = 0.0 
player_y = 0.0 
player_z = 0.0


p2game_time_flag = 0
p2game_timer_start = 0
p2cop_time_limit = 0
p2copcar_timer = 0
p2game_time_present = 0
p2game_time_difference = 0
p2timer_in_secs = 0
p2in_copcar_nice_timer = 0
p2game_timer = 0



// ****************************************START OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdirec
LOAD_SPECIAL_CHARACTER 3 CSMerc
LOAD_SPECIAL_CHARACTER 4 crewa
LOAD_SPECIAL_CHARACTER 5 crewb

LOAD_SPECIAL_MODEL CUTOBJ01 scenery
LOAD_SPECIAL_MODEL CUTOBJ02 drchair

LOAD_SCENE -86.0 929.0 9.764

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0
ENDWHILE

LOAD_CUTSCENE porn_2
SET_CUTSCENE_OFFSET -69.128 920.965 9.764
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_direc
SET_CUTSCENE_ANIM cs_direc CSdirec

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_merc
SET_CUTSCENE_ANIM cs_merc CSMerc

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_crewa
SET_CUTSCENE_ANIM cs_crewa crewa

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_crewb
SET_CUTSCENE_ANIM cs_crewb crewb

CREATE_CUTSCENE_OBJECT CUTOBJ01 cc_scenery
SET_CUTSCENE_ANIM cc_scenery scenery

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drchair
SET_CUTSCENE_ANIM cs_drchair drchair 
 

CLEAR_AREA -66.0 933.04 10.2 1.0 TRUE
SET_PLAYER_COORDINATES player1 -66.0 933.04 10.2
SET_PLAYER_HEADING player1 275.6

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 6922  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW POR2_A 10000 1 // How's filming going Steve?

WHILE cs_time < 8243
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_B 10000 1 // Well Candy is a natural and that new girl -she's insatiable!

WHILE cs_time < 13374
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_C 10000 1 // She went through half the cast and crew already before I even took a light reading.

WHILE cs_time < 17692
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_D 10000 1 // Anyway, heh, tomorrow we're going on location to shoot the boat scenes-

WHILE cs_time < 21037
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_E 10000 1 // Boat scenes, what boat scenes? 

WHILE cs_time < 23916
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_F 10000 1 // The fishermen are in the throws of passion when this giant shark comes in- 

WHILE cs_time < 26964
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_G 10000 1 // What did I say about the giant shark?

WHILE cs_time < 28660
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_Q 10000 1 // Oh, boy.

WHILE cs_time < 30017
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_H 10000 1 // I said, 'NO GIANT SHARK', alright?

WHILE cs_time < 33395
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_I 10000 1 //Just keep the cameras pointed at the poontang!

WHILE cs_time < 35819
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_J 10000 1 //Ok ok, hey Tommy, a guy's gotta try, right?

WHILE cs_time < 38651
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_K 10000 1 //Get those flyers printed up?

WHILE cs_time < 40472
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_L 10000 1 //Yeah, but no one's gonna let us distribute those things, I mean

WHILE cs_time < 43374
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_M 10000 1 //They're just too, uh, they're unimaginative.

WHILE cs_time < 46300
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_N 10000 1 //You don't worry about that.

WHILE cs_time < 47862
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR2_O 10000 1 //I've got my own ideas for distribution

WHILE cs_time < 49597
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF IS_AUSTRALIAN_GAME
//OR IS_JAPANESE_GAME // SCFIX-JAP: removed for compatibility with 1.0
	WHILE cs_time < 49697
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE
	GOTO skip_for_aussie_version2
ENDIF

PRINT_NOW POR2_P 10000 1 //O.K. Hey Candy, uh, in my trailer.

WHILE cs_time < 50597
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//CLEAR_PRINTS

WHILE cs_time < 53376
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

skip_for_aussie_version2:

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0
// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
LOAD_SCENE -67.000 939.297 10.940
SET_CAMERA_BEHIND_PLAYER
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

REQUEST_MODEL skimmer

WHILE NOT HAS_MODEL_LOADED skimmer
	WAIT 0
ENDWHILE

//forcing weather to be nice
FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY

//setting player1 next to plane and creating plane
CREATE_CAR skimmer -141.1 1030.4 7.5 dildodo
SET_CAR_HEADING dildodo 180.0 
ADD_BLIP_FOR_CAR dildodo blip_dildodo

DO_FADE 1500 FADE_IN

PRINT_NOW ( POR2_01 ) 7000 1 //There is a seaplane that was used as a prop in some old Indy film round the back of the studios.
PRINT ( POR2_05 ) 5000 1 //Use it to distribute the flyers around town.


small_dildo_loop:
WAIT 0

IF NOT IS_CAR_DEAD dildodo
	IF IS_PLAYER_IN_CAR player1 dildodo 
		GOTO small_dildo_loop_finished 
	ENDIF
ELSE
	GOTO mission_failed_porn2
ENDIF

GOTO small_dildo_loop

small_dildo_loop_finished:

REMOVE_BLIP blip_dildodo 

PRINT_NOW ( POR2_02 ) 5000 1 //Pick one of the checkpoints to start dropping the flyers from.
PRINT ( POR2_03 ) 5000 1 //Drop the flyers all the way to the end checkpoint.

//setting up checkpoints

ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
CHANGE_BLIP_COLOUR dildocheck_blip1 BLUE
ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
CHANGE_BLIP_COLOUR dildocheck_blip2 BLUE
ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
CHANGE_BLIP_COLOUR dildocheck_blip3 BLUE
ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
CHANGE_BLIP_COLOUR dildocheck_blip4 BLUE
ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
CHANGE_BLIP_COLOUR dildocheck_blip5 BLUE
ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
CHANGE_BLIP_COLOUR dildocheck_blip6 BLUE

timera = 0
//DISPLAY_ONSCREEN_COUNTER dildo_check_counter 0 

DISPLAY_ONSCREEN_COUNTER_WITH_STRING dildo_fuel 1 dildo
timerb = 0


dildo_loop://///////////////////////////////////////////////////////////////////////////////////

WAIT 0



// Stagger this text so they have time to read the help box at top left.


IF NOT IS_CAR_DEAD dildodo

	IF IS_PLAYER_IN_CAR player1 dildodo
		IF plane_help_done = 0
			GET_CONTROLLER_MODE controlmode
			IF controlmode = 3
				PRINT_HELP ( PLANE_4 ) //plane help text
			ELSE
				PRINT_HELP ( PLANE_H ) //plane help text
			ENDIF
			plane_help_done = 1	
		ENDIF
	ENDIF

	IF particle_effect_ok = 0
		IF dildo1 = 0 				//docks > icecream factory
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check1x dildo_check1y dildo_check1z 10.0 10.0 10.0 FALSE
				DRAW_CORONA dildo_check1x dildo_check1y dildo_check1z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
			ELSE
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip1
				dildo_check1x = -872.0 
				dildo_check1y = -574.0
				dildo_check1z = 55.0			 
				ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
				CHANGE_BLIP_COLOUR dildocheck_blip1 RED	 
				REMOVE_BLIP dildocheck_blip2
				REMOVE_BLIP dildocheck_blip3
				REMOVE_BLIP dildocheck_blip4
				REMOVE_BLIP dildocheck_blip5
				REMOVE_BLIP dildocheck_blip6
				particle_effect_ok = 1
				dildo1 = 1
			ENDIF
		ENDIF

		IF dildo2 = 0				//Howling Petes > outside g-spotlight
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check2x dildo_check2y dildo_check2z 10.0 10.0 10.0 FALSE
				DRAW_CORONA dildo_check2x dildo_check2y dildo_check2z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
			ELSE
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip1
				REMOVE_BLIP dildocheck_blip2
				dildo_check2x = -354.2 
				dildo_check2y = 1088.0
				dildo_check2z = 47.0
				ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
				CHANGE_BLIP_COLOUR dildocheck_blip2 RED	 
				REMOVE_BLIP dildocheck_blip3
				REMOVE_BLIP dildocheck_blip4
				REMOVE_BLIP dildocheck_blip5
				REMOVE_BLIP dildocheck_blip6
				particle_effect_ok = 1
				dildo2 = 1
			ENDIF
		ENDIF

		IF dildo3 = 0				//Dirt track > between tall buildings
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check3x dildo_check3y dildo_check3z 10.0 10.0 10.0 FALSE
				DRAW_CORONA dildo_check3x dildo_check3y dildo_check3z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
			ELSE
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip1
				REMOVE_BLIP dildocheck_blip2
				REMOVE_BLIP dildocheck_blip3
				dildo_check3x = -861.4
				dildo_check3y = 1084.8
				dildo_check3z = 54.5
				ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
				CHANGE_BLIP_COLOUR dildocheck_blip3 RED	 
				REMOVE_BLIP dildocheck_blip4
				REMOVE_BLIP dildocheck_blip5
				REMOVE_BLIP dildocheck_blip6
				particle_effect_ok = 1
				dildo3 = 1
			ENDIF
		ENDIF

		IF dildo4 = 0				//Rock City > pizza hut outside haitian base
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check4x dildo_check4y dildo_check4z 10.0 10.0 10.0 FALSE
				DRAW_CORONA dildo_check4x dildo_check4y dildo_check4z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
			ELSE
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip1
				REMOVE_BLIP dildocheck_blip2
				REMOVE_BLIP dildocheck_blip3
				REMOVE_BLIP dildocheck_blip4
				dildo_check4x = -1070.8 
				dildo_check4y = 88.0
				dildo_check4z = 35.0
				ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
				CHANGE_BLIP_COLOUR dildocheck_blip4 RED	 
				REMOVE_BLIP dildocheck_blip5
				REMOVE_BLIP dildocheck_blip6
				particle_effect_ok = 1
				dildo4 = 1
			ENDIF
		ENDIF

		IF dildo5 = 0				//Printing works > Airport 
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check5x dildo_check5y dildo_check5z 10.0 10.0 10.00 FALSE
				DRAW_CORONA dildo_check5x dildo_check5y dildo_check5z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
			ELSE
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip1
				REMOVE_BLIP dildocheck_blip2
				REMOVE_BLIP dildocheck_blip3
				REMOVE_BLIP dildocheck_blip4
				REMOVE_BLIP dildocheck_blip5
				dildo_check5x = -1433.8 
				dildo_check5y = -807.1
				dildo_check5z = 45.5
				ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
				CHANGE_BLIP_COLOUR dildocheck_blip5 RED	 
				REMOVE_BLIP dildocheck_blip6
				particle_effect_ok = 1
				dildo5 = 1
			ENDIF
		ENDIF
	
		IF dildo6 = 0				//bank > between tall buildings
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check6x dildo_check6y dildo_check6z 10.0 10.0 10.00 FALSE
				DRAW_CORONA dildo_check6x dildo_check6y dildo_check6z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
			ELSE
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip1
				REMOVE_BLIP dildocheck_blip2
				REMOVE_BLIP dildocheck_blip3
				REMOVE_BLIP dildocheck_blip4
				REMOVE_BLIP dildocheck_blip5
				REMOVE_BLIP dildocheck_blip6
				dildo_check6x = -771.9 
				dildo_check6y = 304.6
				dildo_check6z = 50.1
				ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
				CHANGE_BLIP_COLOUR dildocheck_blip6 RED	 
				particle_effect_ok = 1
				dildo6 = 1
			ENDIF
		ENDIF
	
	ELSE
	//creating particles
		GENERATE_RANDOM_INT_IN_RANGE 1 7 random_flyers

		IF random_flyers = 1 
			GOSUB creating_flyers
		ENDIF 
		IF random_flyers = 2 
			GOSUB creating_flyers
			GOSUB creating_flyers
		ENDIF 
		IF random_flyers = 3 
			GOSUB creating_flyers
			GOSUB creating_flyers
			GOSUB creating_flyers
		ENDIF 
	
		IF dildo1 = 1 				//docks > icecream factory
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check1x dildo_check1y dildo_check1z 10.0 10.0 10.0 FALSE
				DRAW_CORONA dildo_check1x dildo_check1y dildo_check1z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
			ELSE
				-- dildo_check_counter
				IF dildo2 = 0	 
					ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
					CHANGE_BLIP_COLOUR dildocheck_blip2 BLUE
				ENDIF
				IF dildo3 = 0	 
					ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
					CHANGE_BLIP_COLOUR dildocheck_blip3 BLUE
				ENDIF
				IF dildo4 = 0	 
					ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
					CHANGE_BLIP_COLOUR dildocheck_blip4 BLUE
				ENDIF
				IF dildo5 = 0	 
					ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
					CHANGE_BLIP_COLOUR dildocheck_blip5 BLUE
				ENDIF
				IF dildo6 = 0	 
					ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
					CHANGE_BLIP_COLOUR dildocheck_blip6 BLUE
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip1
				particle_effect_ok = 0
				dildo1 = 2
			ENDIF
		ENDIF

		IF dildo2 = 1				//Howling Petes > outside g-spotlight
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check2x dildo_check2y dildo_check2z 10.0 10.0 10.0 FALSE
				DRAW_CORONA dildo_check2x dildo_check2y dildo_check2z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
			ELSE
				-- dildo_check_counter
				IF dildo1 = 0	 
					ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
					CHANGE_BLIP_COLOUR dildocheck_blip1 BLUE
				ENDIF
				IF dildo3 = 0	 
					ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
					CHANGE_BLIP_COLOUR dildocheck_blip3 BLUE
				ENDIF
				IF dildo4 = 0	 
					ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
					CHANGE_BLIP_COLOUR dildocheck_blip4 BLUE
				ENDIF
				IF dildo5 = 0	 
					ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
					CHANGE_BLIP_COLOUR dildocheck_blip5 BLUE
				ENDIF
				IF dildo6 = 0	 
					ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
					CHANGE_BLIP_COLOUR dildocheck_blip6 BLUE
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip2
				particle_effect_ok = 0
				dildo2 = 2
			ENDIF
		ENDIF

		IF dildo3 = 1				//Dirt track > between tall buildings
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check3x dildo_check3y dildo_check3z 10.0 10.0 10.0 FALSE
				DRAW_CORONA dildo_check3x dildo_check3y dildo_check3z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
			ELSE
				-- dildo_check_counter
				IF dildo1 = 0	 
					ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
					CHANGE_BLIP_COLOUR dildocheck_blip1 BLUE
				ENDIF
				IF dildo2 = 0	 
					ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
					CHANGE_BLIP_COLOUR dildocheck_blip2 BLUE
				ENDIF
				IF dildo4 = 0	 
					ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
					CHANGE_BLIP_COLOUR dildocheck_blip4 BLUE
				ENDIF
				IF dildo5 = 0	 
					ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
					CHANGE_BLIP_COLOUR dildocheck_blip5 BLUE
				ENDIF
				IF dildo6 = 0	 
					ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
					CHANGE_BLIP_COLOUR dildocheck_blip6 BLUE
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip3
				particle_effect_ok = 0
				dildo3 = 2
			ENDIF
		ENDIF

		IF dildo4 = 1				//Rock City > pizza hut outside haitian base
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check4x dildo_check4y dildo_check4z 10.0 10.0 10.0 FALSE
				DRAW_CORONA dildo_check4x dildo_check4y dildo_check4z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
			ELSE
				-- dildo_check_counter
				IF dildo1 = 0	 
					ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
					CHANGE_BLIP_COLOUR dildocheck_blip1 BLUE
				ENDIF
				IF dildo2 = 0	 
					ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
					CHANGE_BLIP_COLOUR dildocheck_blip2 BLUE
				ENDIF
				IF dildo3 = 0	 
					ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
					CHANGE_BLIP_COLOUR dildocheck_blip3 BLUE
				ENDIF
				IF dildo5 = 0	 
					ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
					CHANGE_BLIP_COLOUR dildocheck_blip5 BLUE
				ENDIF
				IF dildo6 = 0	 
					ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
					CHANGE_BLIP_COLOUR dildocheck_blip6 BLUE
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip4
				particle_effect_ok = 0
				dildo4 = 2
			ENDIF
		ENDIF

		IF dildo5 = 1				//Printing works > Airport 
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check5x dildo_check5y dildo_check5z 10.0 10.0 10.00 FALSE
				DRAW_CORONA dildo_check5x dildo_check5y dildo_check5z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
			ELSE
				-- dildo_check_counter
				IF dildo1 = 0	 
					ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
					CHANGE_BLIP_COLOUR dildocheck_blip1 BLUE
				ENDIF
				IF dildo2 = 0	 
					ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
					CHANGE_BLIP_COLOUR dildocheck_blip2 BLUE
				ENDIF
				IF dildo3 = 0	 
					ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
					CHANGE_BLIP_COLOUR dildocheck_blip3 BLUE
				ENDIF
				IF dildo4 = 0	 
					ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
					CHANGE_BLIP_COLOUR dildocheck_blip4 BLUE
				ENDIF
				IF dildo6 = 0	 
					ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
					CHANGE_BLIP_COLOUR dildocheck_blip6 BLUE
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip5
				particle_effect_ok = 0
				dildo5 = 2
			ENDIF
		ENDIF
		IF dildo6 = 1				//bank > between tall buildings 
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 dildo_check6x dildo_check6y dildo_check6z 10.0 10.0 10.00 FALSE
				DRAW_CORONA dildo_check6x dildo_check6y dildo_check6z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
			ELSE
				-- dildo_check_counter
				IF dildo1 = 0	 
					ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
					CHANGE_BLIP_COLOUR dildocheck_blip1 BLUE
				ENDIF
				IF dildo2 = 0	 
					ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
					CHANGE_BLIP_COLOUR dildocheck_blip2 BLUE
				ENDIF
				IF dildo3 = 0	 
					ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
					CHANGE_BLIP_COLOUR dildocheck_blip3 BLUE
				ENDIF
				IF dildo4 = 0	 
					ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
					CHANGE_BLIP_COLOUR dildocheck_blip4 BLUE
				ENDIF
				IF dildo5 = 0	 
					ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
					CHANGE_BLIP_COLOUR dildocheck_blip5 BLUE
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP dildocheck_blip6
				particle_effect_ok = 0
				dildo6 = 2
			ENDIF
		ENDIF
	ENDIF

//doing wee timer thingy ma blodger

IF NOT IS_PLAYER_IN_CAR player1 dildodo 
    GET_GAME_TIMER p2game_timer
    p2cop_time_limit = dildo_fuel
    //p2cop_time_limit *= -1
    //p2cop_time_limit += 100
    p2cop_time_limit *= 5000	
	
	IF p2game_time_flag = 0
		GET_GAME_TIMER p2game_timer_start
		IF p2cop_time_limit > 30000 
			p2copcar_timer = 30000
		ELSE
			p2copcar_timer = p2cop_time_limit
		ENDIF 
		p2game_time_flag = 1
	ENDIF
	
	GET_GAME_TIMER p2game_time_present
	p2game_time_difference = p2game_time_present - p2game_timer_start
	p2copcar_timer -= p2game_time_difference
	p2game_timer_start = p2game_time_present
	p2timer_in_secs = p2copcar_timer / 1000
	PRINT_WITH_NUMBER_NOW PORN2_9 p2timer_in_secs 200 1	// You have ~1~ seconds to return to a Skimmer before the mission ends.
	IF p2timer_in_secs < 1 
		IF p2in_copcar_nice_timer < p2game_timer
			PRINT_NOW taxi2 3000 1//Your out of time
			GOTO mission_failed_porn2
		ENDIF
	ELSE
		p2in_copcar_nice_timer = p2game_timer + 1000
	ENDIF
ELSE
	p2game_time_flag = 0
ENDIF




//checking player1 is in car
	IF IS_CAR_UPSIDEDOWN dildodo
	AND IS_CAR_STOPPED dildodo
		flag_dildodo_upsidedown = 1
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player1 dildodo
	AND flag_player_not_in_dildodo = 0
	AND flag_dildodo_upsidedown = 0
		//PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR dildodo blip_dildodo
		REMOVE_BLIP dildocheck_blip1
		REMOVE_BLIP dildocheck_blip2
		REMOVE_BLIP dildocheck_blip3
		REMOVE_BLIP dildocheck_blip4
		REMOVE_BLIP dildocheck_blip5
		REMOVE_BLIP dildocheck_blip6
		flag_player_not_in_dildodo = 1 
	ENDIF

	IF IS_PLAYER_IN_CAR player1 dildodo
	AND flag_player_not_in_dildodo = 1
		REMOVE_BLIP blip_dildodo
		IF dildo1 = 0	 
			ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
			CHANGE_BLIP_COLOUR dildocheck_blip1 BLUE
		ENDIF
		IF dildo2 = 0	 
			ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
			CHANGE_BLIP_COLOUR dildocheck_blip2 BLUE
		ENDIF
		IF dildo3 = 0	 
			ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
			CHANGE_BLIP_COLOUR dildocheck_blip3 BLUE
		ENDIF
		IF dildo4 = 0	 
			ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
			CHANGE_BLIP_COLOUR dildocheck_blip4 BLUE
		ENDIF
		IF dildo5 = 0	 
			ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
			CHANGE_BLIP_COLOUR dildocheck_blip5 BLUE
		ENDIF
		IF dildo6 = 0	 
			ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
			CHANGE_BLIP_COLOUR dildocheck_blip6 BLUE
		ENDIF
		IF dildo1 = 1
			REMOVE_BLIP dildocheck_blip1
		  	ADD_BLIP_FOR_COORD dildo_check1x dildo_check1y dildo_check1z dildocheck_blip1
			CHANGE_BLIP_COLOUR dildocheck_blip1 RED
			REMOVE_BLIP dildocheck_blip2
			REMOVE_BLIP dildocheck_blip3
			REMOVE_BLIP dildocheck_blip4
			REMOVE_BLIP dildocheck_blip5
			REMOVE_BLIP dildocheck_blip6
		ENDIF
		IF dildo2 = 1				
			REMOVE_BLIP dildocheck_blip1
			REMOVE_BLIP dildocheck_blip2
			ADD_BLIP_FOR_COORD dildo_check2x dildo_check2y dildo_check2z dildocheck_blip2
			CHANGE_BLIP_COLOUR dildocheck_blip2 RED
			REMOVE_BLIP dildocheck_blip3
			REMOVE_BLIP dildocheck_blip4
			REMOVE_BLIP dildocheck_blip5
			REMOVE_BLIP dildocheck_blip6
		ENDIF

		IF dildo3 = 1				
			REMOVE_BLIP dildocheck_blip1
			REMOVE_BLIP dildocheck_blip2
			REMOVE_BLIP dildocheck_blip3
			ADD_BLIP_FOR_COORD dildo_check3x dildo_check3y dildo_check3z dildocheck_blip3
			CHANGE_BLIP_COLOUR dildocheck_blip3 RED
			REMOVE_BLIP dildocheck_blip4
			REMOVE_BLIP dildocheck_blip5
			REMOVE_BLIP dildocheck_blip6
		ENDIF

		IF dildo4 = 1				
			REMOVE_BLIP dildocheck_blip1
			REMOVE_BLIP dildocheck_blip2
			REMOVE_BLIP dildocheck_blip3
			REMOVE_BLIP dildocheck_blip4
			ADD_BLIP_FOR_COORD dildo_check4x dildo_check4y dildo_check4z dildocheck_blip4
			CHANGE_BLIP_COLOUR dildocheck_blip4 RED
			REMOVE_BLIP dildocheck_blip5
			REMOVE_BLIP dildocheck_blip6
		ENDIF

		IF dildo5 = 1				
			REMOVE_BLIP dildocheck_blip1
			REMOVE_BLIP dildocheck_blip2
			REMOVE_BLIP dildocheck_blip3
			REMOVE_BLIP dildocheck_blip4
			REMOVE_BLIP dildocheck_blip5
			ADD_BLIP_FOR_COORD dildo_check5x dildo_check5y dildo_check5z dildocheck_blip5
			CHANGE_BLIP_COLOUR dildocheck_blip5 RED
			REMOVE_BLIP dildocheck_blip6
		ENDIF	
	
		IF dildo6 = 1				
			REMOVE_BLIP dildocheck_blip1
			REMOVE_BLIP dildocheck_blip2
			REMOVE_BLIP dildocheck_blip3
			REMOVE_BLIP dildocheck_blip4
			REMOVE_BLIP dildocheck_blip5
			REMOVE_BLIP dildocheck_blip6
			ADD_BLIP_FOR_COORD dildo_check6x dildo_check6y dildo_check6z dildocheck_blip6
			CHANGE_BLIP_COLOUR dildocheck_blip6 RED
		ENDIF
		CLEAR_PRINTS
		flag_player_not_in_dildodo = 0
	ENDIF
ELSE
	GOTO mission_failed_porn2
ENDIF


// mission fail
IF dildo_fuel = 0
	IF IS_PLAYER_IN_CAR player1 dildodo
		SET_PLAYER_CONTROL player1 OFF
	ENDIF
	IF timerb > 3000
		SET_CAR_CAN_BE_DAMAGED dildodo TRUE
		EXPLODE_CAR dildodo
		GET_CAR_COORDINATES dildodo player_x player_y player_z
		ADD_EXPLOSION player_x player_y player_z EXPLOSION_ROCKET
		ADD_EXPLOSION player_x player_y player_z EXPLOSION_HELI_BOMB  
		ADD_EXPLOSION player_x player_y player_z EXPLOSION_MOLOTOV
		ADD_EXPLOSION player_x player_y player_z EXPLOSION_HELI
		ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE player_x player_y player_z 0.1 0.0 0.2 0.8 0 0 0 11000 
		GOTO mission_failed_porn2 
	ENDIF
ENDIF

IF dildo_fuel > 0 
	IF timerb > 5000
		-- dildo_fuel 
		timerb = 0
	ENDIF
ELSE
	dildo_fuel = 0
ENDIF  

IF dildo_fuel > 0
	IF dildo_fuel < 10
		IF NOT IS_CAR_DEAD dildodo 
			IF IS_PLAYER_IN_CAR player1 dildodo  
				PRINT_NOW ( POR2_04 ) 5000 1 //LOW FUEL!!!
			ELSE
				CLEAR_THIS_PRINT POR2_04
			ENDIF
		ENDIF		
		IF timera > 1000
			GET_CAR_COORDINATES dildodo player_x player_y player_z
			ADD_ONE_OFF_SOUND player_x player_y player_z SOUND_SEAPLANE_LOW_FUEL
			timera = 0
		ENDIF
	ENDIF
ENDIF


//mission passed

IF dildo_check_counter = 0
	GOTO mission_passed_porn2
ENDIF  							   

GOTO dildo_loop////////////////////////////////////////////////////////////
	   		
// Mission failed
mission_failed_porn2:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_porn2:

CLEAR_PRINTS
ADD_PORN_LEAFLET_TO_RUBBISH TRUE
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 2000
SWITCH_CAR_GENERATOR gen_car100 101
PLAYER_MADE_PROGRESS 1 
REGISTER_MISSION_PASSED PORN_2
START_NEW_SCRIPT porn_mission3_loop
flag_porn_mission2_passed = 1
RETURN
		


// mission cleanup
mission_cleanup_porn2:
flag_player_on_mission = 0
SET_PLAYER_CONTROL player1 on
MARK_MODEL_AS_NO_LONGER_NEEDED skimmer
CLEAR_ONSCREEN_COUNTER dildo_check_counter
CLEAR_ONSCREEN_COUNTER dildo_fuel
REMOVE_BLIP blip_dildodo
REMOVE_BLIP dildocheck_blip1
REMOVE_BLIP dildocheck_blip2
REMOVE_BLIP dildocheck_blip3
REMOVE_BLIP dildocheck_blip4
REMOVE_BLIP dildocheck_blip5
REMOVE_BLIP dildocheck_blip6
GET_GAME_TIMER timer_mobile_start
RELEASE_WEATHER
MISSION_HAS_FINISHED
RETURN

///////////////////////////////////////////////////////////////////////////////////////////
creating_flyers:///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GET_OFFSET_FROM_CAR_IN_WORLD_COORDS dildodo 0.0 -2.0 -2.0 player_x player_y player_z
CREATE_SINGLE_PARTICLE PARTICLE_FLYERS player_x player_y player_z 0.0 0.0 0.0 0.8   
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
}