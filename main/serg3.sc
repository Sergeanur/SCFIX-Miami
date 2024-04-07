MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Sergio3***************************************** 
// *****************************************************************************************

// This mission is actually Avery Carrington 2 : Demolition man.

// *****************************************************************************************
// *****************************************************************************************

{

SCRIPT_NAME serg3

// Mission start stuff

GOSUB mission_start_serg2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_serg2_failed
ENDIF
GOSUB mission_cleanup_serg2
MISSION_END

//vans location
VAR_FLOAT vanlocx_s3 vanlocy_s3 vanlocz_s3 vanheading_s3 

// variables for mission
VAR_INT vanblip_s3 targets_to_go
VAR_INT van_s3
VAR_INT players_wanted_level_s3 wanted_level_s3

//builders guarding the site
VAR_INT	builder1
VAR_INT	builder2
VAR_INT	builder3
VAR_INT	builder4
VAR_INT	builder5
VAR_INT	builder6
VAR_INT builder7
VAR_INT builder8
VAR_INT builder9
VAR_INT builder10
VAR_INT builder11
VAR_INT builder12
VAR_INT builder13
VAR_INT security1_s3
VAR_INT security2_s3
VAR_INT security3_s3

//the copter
VAR_INT rc_goblin_s3

//copter's starting coords
VAR_FLOAT rc_goblinx_s3 
VAR_FLOAT rc_gobliny_s3 
VAR_FLOAT rc_goblinz_s3
VAR_FLOAT rc_goblinheading_s3

//copter's current coords
VAR_FLOAT current_goblinx_s3 
VAR_FLOAT current_gobliny_s3 
VAR_FLOAT current_goblinz_s3

//the bombs
VAR_INT timer_bomb1_s3
VAR_INT timer_bomb2_s3
VAR_INT timer_bomb3_s3
VAR_INT timer_bomb4_s3
VAR_INT timer_bomb1_blip_s3
VAR_INT timer_bomb2_blip_s3
VAR_INT timer_bomb3_blip_s3
VAR_INT timer_bomb4_blip_s3

//bombs location
VAR_FLOAT timer_bomb1_pickupx_s3
VAR_FLOAT timer_bomb1_pickupy_s3
VAR_FLOAT timer_bomb1_pickupz_s3

VAR_FLOAT timer_bomb2_pickupx_s3
VAR_FLOAT timer_bomb2_pickupy_s3
VAR_FLOAT timer_bomb2_pickupz_s3

VAR_FLOAT timer_bomb3_pickupx_s3
VAR_FLOAT timer_bomb3_pickupy_s3
VAR_FLOAT timer_bomb3_pickupz_s3

VAR_FLOAT timer_bomb4_pickupx_s3
VAR_FLOAT timer_bomb4_pickupy_s3
VAR_FLOAT timer_bomb4_pickupz_s3


//bombs current locations
VAR_FLOAT current_bomb1_pickupx_s3
VAR_FLOAT current_bomb1_pickupy_s3
VAR_FLOAT current_bomb1_pickupz_s3

VAR_FLOAT current_bomb2_pickupx_s3
VAR_FLOAT current_bomb2_pickupy_s3
VAR_FLOAT current_bomb2_pickupz_s3

VAR_FLOAT current_bomb3_pickupx_s3
VAR_FLOAT current_bomb3_pickupy_s3
VAR_FLOAT current_bomb3_pickupz_s3

VAR_FLOAT current_bomb4_pickupx_s3
VAR_FLOAT current_bomb4_pickupy_s3
VAR_FLOAT current_bomb4_pickupz_s3


//targets that player has to eliminate
VAR_FLOAT target1x_s3
VAR_FLOAT target1y_s3
VAR_FLOAT target1z_s3

VAR_FLOAT target2x_s3
VAR_FLOAT target2y_s3
VAR_FLOAT target2z_s3

VAR_FLOAT target3x_s3
VAR_FLOAT target3y_s3
VAR_FLOAT target3z_s3

VAR_FLOAT target4x_s3
VAR_FLOAT target4y_s3
VAR_FLOAT target4z_s3

VAR_INT target1_blip_s3
VAR_INT target2_blip_s3
VAR_INT target3_blip_s3
VAR_INT target4_blip_s3

//checks to see whether player can drop bomb
VAR_FLOAT bomb1_ready
VAR_FLOAT bomb2_ready
VAR_FLOAT bomb3_ready
VAR_FLOAT bomb4_ready

VAR_FLOAT minimum_dist1_s3
VAR_FLOAT minimum_dist2_s3
VAR_FLOAT minimum_dist3_s3
VAR_FLOAT minimum_dist4_s3


//flags
VAR_INT player_in_van_for_first_time

VAR_INT bomb1_state 
VAR_INT bomb2_state 
VAR_INT bomb3_state 
VAR_INT bomb4_state

VAR_INT target1_hit
VAR_INT target2_hit
VAR_INT target3_hit
VAR_INT target4_hit
VAR_INT highlight_targets
VAR_INT bomb1_is_in_zone
VAR_INT timer_s3

VAR_INT start_timer_on_first_hit

VAR_INT x_bombs_to_go

VAR_INT three_more_to_go
VAR_INT two_more_to_go
VAR_INT one_more_to_go
VAR_INT three_more_to_go1
VAR_INT two_more_to_go1
VAR_INT one_more_to_go1
VAR_INT three_more_to_go2
VAR_INT two_more_to_go2
VAR_INT one_more_to_go2
//REMOVE WHEN GET COMMAND TO LOCATE OBJECTS
VAR_INT camera_s3

VAR_FLOAT locate_t1_b1x
VAR_FLOAT locate_t1_b1y
VAR_FLOAT locate_t1_b1z
VAR_INT builder1_blip
VAR_INT builder2_blip
VAR_INT builder3_blip
VAR_INT builder4_blip

VAR_INT dmbarrel1
VAR_INT dmbarrel2
VAR_INT dmbarrel3
VAR_INT dmbarrel4

VAR_INT builder1attack
VAR_INT builder2attack
VAR_INT builder3attack
VAR_INT builder5attack
VAR_INT builder6attack 
VAR_INT builder7attack
VAR_INT builder8attack
VAR_INT builder9attack
VAR_INT builder10attack
VAR_INT builder11attack
VAR_INT builder12attack
VAR_INT builder13attack

VAR_INT sphere1_s3
VAR_INT spheres3_flag lock_door_flag_s3	print_help_s3 

VAR_INT playingaudio_s3
VAR_INT playingaudio_s3state
VAR_INT builder1played
VAR_INT builder3played
VAR_INT builder7played
VAR_INT builder13played
VAR_INT builder9played


VAR_INT fire3_s3
VAR_INT fire4_s3
VAR_INT fire5_s3
VAR_INT fire6_s3

VAR_INT firea_s3
VAR_INT fireb_s3
VAR_INT firec_s3
VAR_INT fired_s3 vancreated_s3

//security audio
VAR_INT security2_s3played
VAR_INT security2_s3attacked


// ****************************************Mission Start************************************

mission_start_serg2:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1
flag_player_on_rc_mission = 1 //PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX

WAIT 0


LOAD_MISSION_TEXT serg3
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 252.7968 -230.9387 9.8638 333.9001

DO_FADE 1500 FADE_IN

// *****************************************Set Flags/variables************************************

 

// *******************************************Set Coords*****************************************
// pony van
vanlocx_s3 = 226.9151
vanlocy_s3 = -352.2110  
vanlocz_s3 = 9.9086
vanheading_s3 = 79.9842

//RCgoblin
rc_goblinx_s3 = 226.1920
rc_gobliny_s3 = -342.56923
rc_goblinz_s3 = 10.3744
rc_goblinheading_s3 = 87.8676

//bomb starting locations
timer_bomb1_pickupx_s3 = 229.8516  
timer_bomb1_pickupy_s3 = -347.1100
timer_bomb1_pickupz_s3 = 10.0998

timer_bomb2_pickupx_s3 = 229.8516  
timer_bomb2_pickupy_s3 = -344.0284
timer_bomb2_pickupz_s3 = 10.1517

timer_bomb3_pickupx_s3 = 229.8516
timer_bomb3_pickupy_s3 = -341.11006
timer_bomb3_pickupz_s3 = 10.56018

timer_bomb4_pickupx_s3 = 229.8516
timer_bomb4_pickupy_s3 = -338.1100
timer_bomb4_pickupz_s3 = 10.464787



//target locations
target1x_s3 = 97.574  
target1y_s3 = -381.658
target1z_s3 = 7.6407

target2x_s3 = 156.5491  
target2y_s3 = -348.0284
target2z_s3 = 16.8517

target3x_s3 = 88.1474  
target3y_s3 = -361.8685
target3z_s3 = 26.0760

target4x_s3 = 140.0079
target4y_s3 = -383.1253
target4z_s3 = 35.3172

//builders location

 
three_more_to_go = 0
two_more_to_go = 0
one_more_to_go = 0
three_more_to_go1 = 0
two_more_to_go1	= 0
one_more_to_go1	= 0
three_more_to_go2 = 0
two_more_to_go2	= 0
one_more_to_go2 = 0

//flags
player_in_van_for_first_time = 0
highlight_targets = 0
bomb1_state = 0
bomb2_state = 0
bomb3_state = 0
bomb4_state = 0

target1_hit = 0	
target2_hit = 0
target3_hit = 0
target4_hit = 0

bomb1_is_in_zone = 0

start_timer_on_first_hit = 0

x_bombs_to_go = 0

builder1attack = 0
builder2attack = 0
builder3attack = 0
builder5attack = 0
builder6attack = 0 
builder7attack = 0
builder8attack = 0
builder10attack	= 0
builder11attack	= 0
builder12attack	= 0
builder13attack	= 0

builder9attack = 0
security2_s3attacked = 0

//create the rc goblin
spheres3_flag = 0
camera_s3 = 0
lock_door_flag_s3 = 0
targets_to_go = 4

vancreated_s3 = 0

//help flag
print_help_s3 = 0


//audio flags
playingaudio_s3 = 0
playingaudio_s3state = 0
builder1played = 0
builder3played = 0
builder7played = 0
builder13played = 0

builder9played = 0
security2_s3played = 0

// ********************************** SCRIPTED CUT - AVERY'S STRETCH ARRIVES ***************

FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY
SET_PLAYER_CONTROL player1 OFF // SCFIX
SWITCH_WIDESCREEN ON

CLEAR_AREA 299.0 -205.0 10.5 5.0 TRUE
CLEAR_AREA 305.0 -219.5 10.5 10.0 TRUE
SET_PLAYER_COORDINATES player1 299.0 -205.0 10.5
SET_PLAYER_HEADING player1 230.0
SET_FIXED_CAMERA_POSITION 297.0 -204.7 13.0 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 318.5 -219.23 22.4 JUMP_CUT
REQUEST_MODEL stretch
LOAD_SCENE 270.0 -218.0 13.4
WHILE NOT HAS_MODEL_LOADED stretch
	WAIT 0
ENDWHILE

CLEAR_AREA 306.9 -241.65 12.3 15.0 TRUE
CREATE_CAR stretch 306.9 -241.65 12.3 scripted_cut_limo
CHANGE_CAR_COLOUR scripted_cut_limo 0 0
SET_CAR_HEADING scripted_cut_limo 0.0


DO_FADE 1500 FADE_IN
WHILE GET_FADING_STATUS 
	WAIT 0
ENDWHILE

IF NOT IS_CAR_DEAD scripted_cut_limo
	SET_CAR_FORWARD_SPEED scripted_cut_limo 15.0
	SET_CAR_TEMP_ACTION scripted_cut_limo TEMPACT_GOFORWARD 8000
ENDIF

timera = 0
WHILE timera < 1000
	WAIT 0
ENDWHILE
IF NOT IS_CAR_DEAD scripted_cut_limo
	POINT_CAMERA_AT_CAR scripted_cut_limo FIXED INTERPOLATION
ENDIF
timera = 0
WHILE timera < 3000
	WAIT 0
ENDWHILE
IF NOT IS_CAR_DEAD scripted_cut_limo
	GET_CAR_COORDINATES scripted_cut_limo vect_x vect_y vect_z
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer vect_x vect_y   
ENDIF
DO_FADE 1500 FADE_OUT
WHILE GET_FADING_STATUS 
	WAIT 0
ENDWHILE
DELETE_CAR scripted_cut_limo
MARK_MODEL_AS_NO_LONGER_NEEDED stretch
RESTORE_CAMERA
SET_CHAR_OBJ_NO_OBJ scplayer
CHAR_SET_IDLE scplayer
TIMERA = 0


// ****************************************START OF CUTSCENE********************************

VAR_INT cut_limo

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSavery

LOAD_SPECIAL_MODEL CUTOBJ01 cs_limo

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0
ENDWHILE


LOAD_CUTSCENE tex_3

SET_CUTSCENE_OFFSET 305.2 -211.9 11.3
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_avery
SET_CUTSCENE_ANIM cs_avery CSavery

CREATE_CUTSCENE_OBJECT CUTOBJ01 cut_limo

//hide player
CLEAR_AREA 265.129 -234.531 11.107 1.0 TRUE
SET_PLAYER_COORDINATES player1 265.129 -234.531 11.1013
SET_PLAYER_HEADING player1 78.218376
REQUEST_COLLISION 265.129 -234.531 


DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time


WHILE cs_time < 1378   
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_A ) 10000 1 //Now look here, son. I got a problem and I reckon you could help me with.

WHILE cs_time < 6014   
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_B ) 10000 1 //I'm no builder.


WHILE cs_time <  7125 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_C ) 10000 1 //No, I was thinking more of your demolition skills.

WHILE cs_time < 11052
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_D ) 10000 1 // Now this here, this is the development as planned and this; 

WHILE cs_time < 15314
 	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_E ) 10000 1 //this is the property that we're looking at.

WHILE cs_time <  17674
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_F ) 10000 1 //You're trying to say this new office block is kind of in the way. 


WHILE cs_time < 20508
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_G ) 10000 1 //You catch on quick.


WHILE cs_time < 22010
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_H ) 10000 1 //Now I'm going to head out of town for a while

WHILE cs_time < 24331
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_I ) 10000 1 //and if that office development were to face sudden and insurmountable structural problems, then I..

WHILE cs_time < 30049
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_J ) 10000 1 //As a civil minded individual you'd feel obliged to step in and
 
WHILE cs_time < 33978
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_K ) 10000 1 //save the rejuvenation of an important area of the city?
  
WHILE cs_time < 37030
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX3_L ) 10000 1 //Where can I get more guys like you?

WHILE cs_time < 39030
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
RELEASE_WEATHER


SET_AREA_VISIBLE VIS_MAIN_MAP
SET_PLAYER_CONTROL player1 ON // SCFIX

DO_FADE 1500 FADE_IN




// ******************************************END OF CUTSCENE*********************************




// Mission 
REQUEST_MODEL dynamite
REQUEST_MODEL TOPFUN
REQUEST_MODEL WMYCW
REQUEST_MODEL HAMMER
REQUEST_MODEL RCgoblin
REQUEST_MODEL barrel2
REQUEST_MODEL GDa
REQUEST_MODEL colt45


WHILE NOT HAS_MODEL_LOADED dynamite
   OR NOT HAS_MODEL_LOADED HAMMER
   OR NOT HAS_MODEL_LOADED WMYCW 
   OR NOT HAS_MODEL_LOADED TOPFUN
   OR NOT HAS_MODEL_LOADED barrel2
   OR NOT HAS_MODEL_LOADED colt45
   WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED GDa
    WAIT 0
ENDWHILE



//disable detonations
SET_ENABLE_RC_DETONATE FALSE
  

//create pony
CLEAR_AREA vanlocx_s3 vanlocy_s3 vanlocz_s3 35.0 FALSE 
CREATE_CAR TOPFUN vanlocx_s3 vanlocy_s3 vanlocz_s3 van_s3
vancreated_s3 = 1
SET_CAR_HEADING van_s3 vanheading_s3								
ADD_BLIP_FOR_CAR van_s3 vanblip_s3

PRINT_NOW ( TEX3_16 ) 7000 2

SWITCH_PED_ROADS_OFF 208.6046 -355.3371 -5.5941 248.6443 -338.1352 12.9291

FREEZE_CAR_POSITION van_s3 TRUE
					  
mission_serg2_loop:

WAIT 0

IF NOT IS_CAR_DEAD van_s3
	IF IS_PLAYER_SITTING_IN_CAR player1 van_s3
		IF lock_door_flag_s3 = 0
			LOCK_CAR_DOORS van_s3 CARLOCK_LOCKED
			WAIT 1000
			lock_door_flag_s3 = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD van_s3
	IF NOT IS_PLAYER_SITTING_IN_CAR player1 van_s3
		IF lock_door_flag_s3 = 1
			LOCK_CAR_DOORS van_s3 CARLOCK_UNLOCKED
			lock_door_flag_s3 = 0
		ENDIF
	ENDIF
ENDIF

													////////////////// MISSION START //////////////////

//remove blip and lock doors when player gets in and create van
IF NOT IS_CAR_DEAD van_s3
	IF IS_PLAYER_IN_CAR player1 van_s3	//sitting
		IF player_in_van_for_first_time = 0
		AND lock_door_flag_s3 = 1

			   ///////////////////CREATING BUILDERS
		
		   SET_EVERYONE_IGNORE_PLAYER player1 ON 	
		   CREATE_OBJECT barrel2 97.574 -381.658 7.9721 dmbarrel1
		   CREATE_OBJECT barrel2 156.5491 -348.0284 16.8517 dmbarrel2
		   CREATE_OBJECT barrel2 88.1474 -361.8685 26.0760 dmbarrel3
		   CREATE_OBJECT barrel2 140.0079 -383.1253 35.3172 dmbarrel4

		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 121.4188 -371.5533 7.6307 builder1	//doing nothing
		   GIVE_WEAPON_TO_CHAR builder1 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder1 189.9082 
		   SET_CHAR_RUNNING builder1 TRUE
		   
   	   	   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 160.0738 -375.7540 7.6307 builder2 //hammer
		   GIVE_WEAPON_TO_CHAR builder2 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING	builder2 268.8645
		   SET_CHAR_RUNNING builder2 TRUE
		   
   	   	   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 116.1989 -348.1792 16.8494 builder3  //chatting
		   GIVE_WEAPON_TO_CHAR builder3 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING	builder3 288.6831
		   SET_CHAR_RUNNING builder3 TRUE
		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 117.5286 -348.1254 16.8494 builder4  //chatting
		   GIVE_WEAPON_TO_CHAR builder4 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder4 110.9578  
		   SET_CHAR_RUNNING builder4 TRUE
		   SET_CHARS_CHATTING builder4 builder3 800000

		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 160.1008 -356.3203 16.8517 builder5 //hammer
		   GIVE_WEAPON_TO_CHAR builder5 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder5 277.8673
		   SET_CHAR_RUNNING builder5 TRUE
		   SET_CHAR_WAIT_STATE builder5 WAITSTATE_USE_ATM 300000
		   
		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 160.3129 -375.7929 16.8517 builder6 //hammer
		   GIVE_WEAPON_TO_CHAR builder6 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder6 261.6740
		   SET_CHAR_RUNNING builder6 TRUE
		   SET_CHAR_WAIT_STATE builder6 WAITSTATE_USE_ATM 300000

		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 81.4138 -356.4398 26.0760 builder7	//hammer
		   GIVE_WEAPON_TO_CHAR builder7 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder7 87.3059
		   SET_CHAR_RUNNING builder7 TRUE
		   SET_CHAR_WAIT_STATE builder7 WAITSTATE_USE_ATM 300000
		   			
		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 81.5607 -354.9395 26.0760 builder8	//chat waitstate
		   GIVE_WEAPON_TO_CHAR builder8 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder8 176.8125
		   SET_CHAR_RUNNING builder8 TRUE
		   SET_CHAR_WAIT_STATE builder8 WAITSTATE_PLAYANIM_CHAT 800000
		   
		   CREATE_CHAR PEDTYPE_CIVMALE GDa 121.0359 -379.1090 26.0805 builder9	//wander  //SECURITY GUARD
		   GIVE_WEAPON_TO_CHAR builder9 WEAPONTYPE_PISTOL 300000
		   SET_CHAR_HEADING builder9 15.4943
		   SET_CHAR_RUNNING builder9 TRUE
		   SHUT_CHAR_UP builder9 TRUE

		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 112.2413 -356.3021 35.3172 builder10 //hammer
		   GIVE_WEAPON_TO_CHAR builder10 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder10 278.5729
		   SET_CHAR_RUNNING builder10 TRUE
		   			
		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 98.2973 -376.0110 35.3172 builder11 //hammer
		   GIVE_WEAPON_TO_CHAR builder11 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder11 76.4463
		   SET_CHAR_RUNNING builder11 TRUE
		   
		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 160.5181 -356.3491 35.3172 builder12 //hammer
		   GIVE_WEAPON_TO_CHAR builder12 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder12 278.5729
		   SET_CHAR_RUNNING builder12 TRUE
		   
		   CREATE_CHAR PEDTYPE_CIVMALE WMYCW 129.3469 -366.2533 35.3172 builder13 //hammer
		   GIVE_WEAPON_TO_CHAR builder13 WEAPONTYPE_HAMMER 1
		   SET_CHAR_HEADING builder13 84.4686
		   SET_CHAR_RUNNING builder13 TRUE
		   	   		     	   		   
		   CREATE_CHAR PEDTYPE_CIVMALE GDa 120.1059 -346.0308 35.3104 security1_s3 //gun
		   GIVE_WEAPON_TO_CHAR security1_s3 WEAPONTYPE_PISTOL 300000
		   SET_CHAR_HEADING security1_s3 185.8660
		   SET_CHAR_RUNNING security1_s3 TRUE
		   SET_CHAR_ACCURACY security1_s3 80
		   SHUT_CHAR_UP security1_s3 TRUE

		   CREATE_CHAR PEDTYPE_CIVMALE GDa 123.3658 -380.2271 35.3172 security2_s3 //gun
		   GIVE_WEAPON_TO_CHAR security2_s3 WEAPONTYPE_PISTOL 300000
		   SET_CHAR_HEADING security2_s3 358.9169
		   SET_CHAR_RUNNING security2_s3 TRUE
		   SHUT_CHAR_UP security2_s3 TRUE

		   CREATE_CHAR PEDTYPE_CIVMALE GDa 104.143 -346.1777 26.268 security3_s3 //gun
		   GIVE_WEAPON_TO_CHAR security3_s3 WEAPONTYPE_PISTOL 300000
		   SET_CHAR_HEADING security3_s3 185.8660
		   SET_CHAR_RUNNING security3_s3 TRUE
		   SHUT_CHAR_UP security3_s3 TRUE
		   
		   REMOVE_BLIP vanblip_s3
		   				   
		   SET_POLICE_IGNORE_PLAYER player1 ON
	       STORE_WANTED_LEVEL player1 wanted_level_s3
		   CLEAR_WANTED_LEVEL player1
		   		   			   
		   SWITCH_WIDESCREEN ON
		   SET_PLAYER_CONTROL player1 OFF
		   			   			   
		   //give player remote copter
		   GIVE_REMOTE_CONTROLLED_MODEL_TO_PLAYER player1 rc_goblinx_s3 rc_gobliny_s3 rc_goblinz_s3 rc_goblinheading_s3 RCgoblin
		   GET_REMOTE_CONTROLLED_CAR player1 rc_goblin_s3
		   SET_CAR_HEALTH rc_goblin_s3 1400

		   //create timer bombs
		   CREATE_OBJECT dynamite timer_bomb1_pickupx_s3 timer_bomb1_pickupy_s3 timer_bomb1_pickupz_s3 timer_bomb1_s3
		   SET_OBJECT_COLLISION timer_bomb1_s3 TRUE
		   SET_OBJECT_DYNAMIC timer_bomb1_s3 TRUE
		   ADD_BLIP_FOR_OBJECT timer_bomb1_s3 timer_bomb1_blip_s3


		   CREATE_OBJECT dynamite timer_bomb2_pickupx_s3 timer_bomb2_pickupy_s3 timer_bomb2_pickupz_s3 timer_bomb2_s3
		   SET_OBJECT_COLLISION timer_bomb2_s3 TRUE
		   SET_OBJECT_DYNAMIC timer_bomb2_s3 TRUE
		   //SET_OBJECT_RECORDS_COLLISIONS timer_bomb2_s3 TRUE
		   ADD_BLIP_FOR_OBJECT timer_bomb2_s3 timer_bomb2_blip_s3

		   CREATE_OBJECT dynamite timer_bomb3_pickupx_s3 timer_bomb3_pickupy_s3 timer_bomb3_pickupz_s3 timer_bomb3_s3
		   SET_OBJECT_COLLISION timer_bomb3_s3 TRUE
		   SET_OBJECT_DYNAMIC timer_bomb3_s3 TRUE
		   //SET_OBJECT_RECORDS_COLLISIONS timer_bomb3_s3 TRUE
		   ADD_BLIP_FOR_OBJECT timer_bomb3_s3 timer_bomb3_blip_s3


		   CREATE_OBJECT dynamite timer_bomb4_pickupx_s3 timer_bomb4_pickupy_s3 timer_bomb4_pickupz_s3 timer_bomb4_s3
		   SET_OBJECT_COLLISION timer_bomb4_s3 TRUE
		   SET_OBJECT_DYNAMIC timer_bomb4_s3 TRUE
		   //SET_OBJECT_RECORDS_COLLISIONS timer_bomb4_s3 TRUE
		   ADD_BLIP_FOR_OBJECT timer_bomb4_s3 timer_bomb4_blip_s3

		   FREEZE_OBJECT_POSITION dmbarrel1	TRUE
		   FREEZE_OBJECT_POSITION dmbarrel2	TRUE
		   FREEZE_OBJECT_POSITION dmbarrel3	TRUE
		   FREEZE_OBJECT_POSITION dmbarrel4	TRUE
				

		   SET_FIXED_CAMERA_POSITION 275.698853 -255.776352 35.368149 0.0 0.0 0.0  //building shot
		   POINT_CAMERA_AT_POINT 274.904907 -256.375183 35.47337 JUMP_CUT
		   CLEAR_AREA rc_goblinx_s3 rc_gobliny_s3 rc_goblinz_s3 15.0 FALSE

		   TIMERA = 0

		   WHILE TIMERA < 5000
		   			   
		   WAIT 0
		
		   PRINT_NOW ( TEX3_1 ) 5000 2
					
				IF IS_BUTTON_PRESSED PAD1 cross
				AND TIMERA > 1000
					GOTO end_of_demolition_cutscene
				ENDIF


		   ENDWHILE
		
		   SET_FIXED_CAMERA_POSITION 221.931839 -347.825348 14.86874 0.0 0.0 0.0  //heli shot
		   POINT_CAMERA_AT_POINT 222.581650 -347.262512 14.357430 JUMP_CUT


		   TIMERA = 0

		   WHILE TIMERA < 5000

		   WAIT 0
		
		   PRINT_NOW ( TEX3_2 ) 5000 2
				
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_demolition_cutscene
				ENDIF


		   ENDWHILE

		   SET_FIXED_CAMERA_POSITION 229.985306 -348.742728 11.148973 0.0 0.0 0.0  //bomb shot
		   POINT_CAMERA_AT_POINT 229.951279 -347.861328 10.677962 JUMP_CUT	

		   TIMERA = 0

		   WHILE TIMERA < 5000

		   WAIT 0
		
		   PRINT_NOW ( TEX3_30 ) 5000 2
			
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_demolition_cutscene
				ENDIF

		   ENDWHILE


		   SET_FIXED_CAMERA_POSITION 94.208 -381.946 8.67 0.0 0.0 0.0  //1st target
		   POINT_CAMERA_AT_POINT 95.284414 -381.862 8.660458 JUMP_CUT
		   CLEAR_AREA rc_goblinx_s3 rc_gobliny_s3 rc_goblinz_s3 10.0 FALSE

		   TIMERA = 0

		   WHILE TIMERA < 5000
		   			   
		   WAIT 0
		
			  GET_CONTROLLER_MODE controlmode

			  IF controlmode = 3
		      	PRINT_NOW ( TEX3_39 ) 5000 2 //circle
			  ELSE
		      	PRINT_NOW ( TEX3_4 ) 5000 2 //circle
			  ENDIF


			   IF IS_BUTTON_PRESSED PAD1 cross
			    	GOTO end_of_demolition_cutscene
			   ENDIF
		   
		   ENDWHILE	
		   		   
		   SET_FIXED_CAMERA_POSITION 153.356705 -365.005096 17.809898 0.0 0.0 0.0  //2nd target
		   POINT_CAMERA_AT_POINT 153.537766 -364.021729 17.823509 JUMP_CUT
									 
		   TIMERA = 0

		   WHILE TIMERA < 5000

		   WAIT 0
		
		   PRINT_NOW ( TEX3_5 ) 5000 2
				
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_demolition_cutscene
				ENDIF

				IF NOT IS_CHAR_DEAD builder5
					SET_CHAR_WAIT_STATE builder5 WAITSTATE_USE_ATM 300000
				ENDIF

				IF NOT IS_CHAR_DEAD builder6
					SET_CHAR_WAIT_STATE builder6 WAITSTATE_USE_ATM 300000
				ENDIF

		   ENDWHILE

		   SET_FIXED_CAMERA_POSITION 93.859215 -360.954346 27.008280 0.0 0.0 0.0  //3rd target
		   POINT_CAMERA_AT_POINT 92.861099 -361.013611 26.992144 JUMP_CUT 

		   TIMERA = 0

		   WHILE TIMERA < 5000

		   WAIT 0
		
		   PRINT_NOW ( TEX3_6 ) 5000 2
					
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_demolition_cutscene
				ENDIF

				IF NOT IS_CHAR_DEAD builder7
					SET_CHAR_WAIT_STATE builder7 WAITSTATE_USE_ATM 300000
				ENDIF
			
		   ENDWHILE


		   SET_FIXED_CAMERA_POSITION 120.766960 -377.225586 35.945694 0.0 0.0 0.0  //4th target
		   POINT_CAMERA_AT_POINT 121.699638 -377.580963 36.007435 JUMP_CUT 

		   TIMERA = 0

		   WHILE TIMERA < 5000

		   WAIT 0
		
		   PRINT_NOW ( TEX3_7 ) 5000 2
					
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_demolition_cutscene
				ENDIF


		   ENDWHILE

		   SET_FIXED_CAMERA_POSITION 117.722252 -388.837280 10.207084 0.0 0.0 0.0  //stairs
		   POINT_CAMERA_AT_POINT 117.743431 -387.838593 10.258373 JUMP_CUT 

		   TIMERA = 0

		   WHILE TIMERA < 5000

		   WAIT 0
		
		   PRINT_NOW ( TEX3_27 ) 5000 2
					
		   IF IS_BUTTON_PRESSED PAD1 cross
		   		GOTO end_of_demolition_cutscene
		   ENDIF
		   

		   ENDWHILE


end_of_demolition_cutscene:

		   WAIT 0	
		   
		   CLEAR_PRINTS 
		   SWITCH_WIDESCREEN OFF
		   SET_PLAYER_CONTROL player1 ON

		   IF NOT IS_CAR_DEAD rc_goblin_s3
    	   		POINT_CAMERA_AT_CAR rc_goblin_s3 CAM_ON_A_STRING JUMP_CUT 
			   	WAIT 0
				SET_CAMERA_ZOOM 0
		   ENDIF

		   DISPLAY_ONSCREEN_COUNTER_WITH_STRING targets_to_go COUNTER_DISPLAY_NUMBER ( TEX3_11 )
		   //PRINT NOW use your copter etc. to bomb and then CUT TO BUILDING SITE AND SHOW BOMB LOCATIONS

			   player_in_van_for_first_time = 1
		ENDIF
	ENDIF
ENDIF

												////////////////// HELP TEXT //////////////////
IF player_in_van_for_first_time = 1
	IF print_help_s3 = 0
		TIMERA = 0
		GET_CONTROLLER_MODE controlmode
		IF controlmode = 3
			PRINT_HELP PLANE_4
		ELSE
			PRINT_HELP PLANE_H
		ENDIF
		print_help_s3 = 1
	ENDIF
ENDIF

IF player_in_van_for_first_time = 1
	IF print_help_s3 = 1
		IF TIMERA > 9500
			PRINT_HELP TEX3_23  // Push the ~h~left analog stick~w~ to tilt the helicopter in the direction you wish to maneuver it.
			TIMERA = 0
			print_help_s3 = 2
		ENDIF
	ENDIF
ENDIF

IF player_in_van_for_first_time = 1
	IF print_help_s3 = 2
		IF TIMERA > 9500
			
			PRINT_HELP TEX3_25  // Press the ~h~R2 ~w~button to rotate the helicopter clockwise.
			
			TIMERA = 0
			print_help_s3 = 3
		ENDIF
	ENDIF
ENDIF

IF player_in_van_for_first_time = 1
	IF print_help_s3 = 3
		IF TIMERA > 9500
			
			PRINT_HELP TEX3_24  // Press the ~h~L2 ~w~button to rotate the helicopter counter-clockwise.
			
			TIMERA = 0
			print_help_s3 = 4
		ENDIF
	ENDIF
ENDIF
IF player_in_van_for_first_time = 1
	IF print_help_s3 = 4
		GET_CONTROLLER_MODE controlmode
		IF NOT controlmode = 3
			IF TIMERA > 9500
				PRINT_HELP TEX3_26
				TIMERA = 0
				print_help_s3 = 5
			ENDIF
		ELSE
			TIMERA = 0
			print_help_s3 = 5
		ENDIF
	ENDIF
ENDIF

IF player_in_van_for_first_time = 1
	IF print_help_s3 = 5
		IF TIMERA > 9500
			PRINT_HELP TEX3_32
			TIMERA = 0
			print_help_s3 = 6
		ENDIF
	ENDIF
ENDIF

IF player_in_van_for_first_time = 1
	IF print_help_s3 = 6
		IF TIMERA > 9500
			PRINT_HELP TEX3_28
			TIMERA = 0
			print_help_s3 = 7
		ENDIF
	ENDIF
ENDIF
IF player_in_van_for_first_time = 1
	IF print_help_s3 = 7
		IF TIMERA > 9500
			GET_CONTROLLER_MODE controlmode
			IF controlmode = 3
				PRINT_HELP ( TEX3_40 ) //circle
			ELSE
				PRINT_HELP ( TEX3_29 ) //circle
			ENDIF

			TIMERA = 0
					
			print_help_s3 = 8
		ENDIF
	ENDIF
ENDIF
IF player_in_van_for_first_time = 1
	IF print_help_s3 = 8
		IF TIMERA > 9500
			PRINT_HELP TEX3_33
			TIMERA = 0
			print_help_s3 = 9
		ENDIF
	ENDIF
ENDIF
IF player_in_van_for_first_time = 1
	IF print_help_s3 = 9
		IF TIMERA > 9500
			PRINT_HELP TEX3_34
			TIMERA = 0
			print_help_s3 = 10
		ENDIF
	ENDIF
ENDIF
IF player_in_van_for_first_time = 1
	IF print_help_s3 = 10
		IF TIMERA > 9500
			PRINT_HELP TEX3_35
			TIMERA = 0
			print_help_s3 = 11
		ENDIF
	ENDIF
ENDIF
IF player_in_van_for_first_time = 1
	IF print_help_s3 = 11
		IF TIMERA > 9500
			PRINT_HELP TEX3_36
			TIMERA = 0
			print_help_s3 = 12
		ENDIF
	ENDIF
ENDIF




	 

											////////////////// CHECKING if heli in range ////////////////
//warning
IF player_in_van_for_first_time = 1
	IF NOT IS_CAR_DEAD rc_goblin_s3
		IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 rc_goblin_s3 200.0 200.0 FALSE
			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 rc_goblin_s3 249.0 249.0 FALSE
				PRINT_NOW ( TEX3_20 ) 1000 1
			ENDIF
		ENDIF
	ENDIF
ENDIF



	

											////////////////// ADDING AND REMOVING BLIPS //////////////////

//get players coords when they have a bomb
IF NOT IS_CAR_DEAD rc_goblin_s3
	IF IS_PLAYER_IN_REMOTE_MODE player1

	   	GET_OBJECT_COORDINATES timer_bomb1_s3 current_bomb1_pickupx_s3 current_bomb1_pickupy_s3 current_bomb1_pickupz_s3
	   	GET_OBJECT_COORDINATES timer_bomb2_s3 current_bomb2_pickupx_s3 current_bomb2_pickupy_s3 current_bomb2_pickupz_s3
	   	GET_OBJECT_COORDINATES timer_bomb3_s3 current_bomb3_pickupx_s3 current_bomb3_pickupy_s3 current_bomb3_pickupz_s3
	   	GET_OBJECT_COORDINATES timer_bomb4_s3 current_bomb4_pickupx_s3 current_bomb4_pickupy_s3 current_bomb4_pickupz_s3
		
	ENDIF
ENDIF




/* bomb states

bomb_state 	= 0  -	grounded
			= 1	 -	on copter
			= 2	 -	has been dropped
			= 3	 -	in 'target zone'

*/


	//bomb1	
	IF bomb1_state = 2
		IF HAS_OBJECT_COLLIDED_WITH_ANYTHING timer_bomb1_s3
			SET_OBJECT_DYNAMIC timer_bomb1_s3 FALSE
			SET_OBJECT_COLLISION timer_bomb1_s3 FALSE
			
			SET_OBJECT_RECORDS_COLLISIONS timer_bomb1_s3 FALSE

			bomb1_state = 0
			GOSUB check_if_bomb1_has_hit_target   //check if bombs have hit target in which case remove target and the bomb and put other bomb blips on

			GOSUB add_bomb_blips_remove_target_blips //add blips for bombs if they are grounded and remove target blips


		ENDIF
	ENDIF
				
	//bomb2
	IF bomb2_state = 2
		IF HAS_OBJECT_COLLIDED_WITH_ANYTHING timer_bomb2_s3
			SET_OBJECT_DYNAMIC timer_bomb2_s3 FALSE
			SET_OBJECT_COLLISION timer_bomb2_s3 FALSE
			
			SET_OBJECT_RECORDS_COLLISIONS timer_bomb2_s3 FALSE

			bomb2_state = 0
			GOSUB check_if_bomb2_has_hit_target

			GOSUB add_bomb_blips_remove_target_blips

		ENDIF
	ENDIF

	//bomb3
	IF bomb3_state = 2
		IF HAS_OBJECT_COLLIDED_WITH_ANYTHING timer_bomb3_s3
			SET_OBJECT_DYNAMIC timer_bomb3_s3 FALSE
			SET_OBJECT_COLLISION timer_bomb3_s3 FALSE
			
			SET_OBJECT_RECORDS_COLLISIONS timer_bomb3_s3 FALSE

			bomb3_state = 0
			GOSUB check_if_bomb3_has_hit_target

			GOSUB add_bomb_blips_remove_target_blips

		ENDIF
	ENDIF

	//bomb4
	IF bomb4_state = 2
		IF HAS_OBJECT_COLLIDED_WITH_ANYTHING timer_bomb4_s3
			SET_OBJECT_DYNAMIC timer_bomb4_s3 FALSE
			SET_OBJECT_COLLISION timer_bomb4_s3 FALSE

			SET_OBJECT_RECORDS_COLLISIONS timer_bomb4_s3 FALSE

			bomb4_state = 0
			GOSUB check_if_bomb4_has_hit_target

			GOSUB add_bomb_blips_remove_target_blips
			
		ENDIF
	ENDIF





												////////////////// PICKING UP AND DROPPING BOMBS	//////////////////

//pickup bomb 1  
IF NOT IS_CAR_DEAD rc_goblin_s3
	IF IS_PLAYER_IN_REMOTE_MODE player1
		IF bomb2_state = 0			  // other bombs are grounded
		OR bomb2_state = 3
			IF bomb3_state = 0
			OR bomb3_state = 3
				IF bomb4_state = 0
				OR bomb4_state = 3
					IF bomb1_state < 2 //while the bomb is not falling
						IF LOCATE_CAR_3D rc_goblin_s3 current_bomb1_pickupx_s3 current_bomb1_pickupy_s3 current_bomb1_pickupz_s3 0.7 0.7 0.7 FALSE
					   	OR bomb1_state = 1 //so bomb does not fly off when sharp collsion or water 
													
							GET_CAR_COORDINATES rc_goblin_s3 current_goblinx_s3 current_gobliny_s3 current_goblinz_s3
							PLACE_OBJECT_RELATIVE_TO_CAR timer_bomb1_s3 rc_goblin_s3 0.0 0.0 -0.4
							
							//start it on first bomb landing
							IF start_timer_on_first_hit = 0
								start_timer_on_first_hit = 1
								
								timer_s3 = 420000		// 7 minutes
							ENDIF
						   	
						   	SET_OBJECT_COLLISION timer_bomb1_s3 FALSE
							SET_OBJECT_DYNAMIC timer_bomb1_s3 FALSE
						   	//minimum distance check
					   		GET_GROUND_Z_FOR_3D_COORD current_goblinx_s3 current_gobliny_s3 current_goblinz_s3 minimum_dist1_s3
					 		bomb1_ready = current_goblinz_s3 - minimum_dist1_s3

						   	IF bomb1_state = 0
								GOSUB add_target_blips_remove_bomb_blips
							ENDIF
							bomb1_state	= 1
							
							IF bomb1_state = 1	// the bomb is on the copter
								IF bomb1_ready > 1.2 
									IF IS_IN_CAR_FIRE_BUTTON_PRESSED
										bomb1_state = 2				//bomb has been dropped
										SET_OBJECT_DYNAMIC timer_bomb1_s3 TRUE
										SET_OBJECT_COLLISION timer_bomb1_s3 TRUE
										SET_OBJECT_RECORDS_COLLISIONS timer_bomb1_s3 TRUE	 //add all the collisions to make it drop and record it
										SORT_OUT_OBJECT_COLLISION_WITH_CAR timer_bomb1_s3 rc_goblin_s3
										SET_OBJECT_VELOCITY timer_bomb1_s3 0.0 0.0 -1.0
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



//pickup bomb 2  
IF NOT IS_CAR_DEAD rc_goblin_s3
	IF IS_PLAYER_IN_REMOTE_MODE player1
		IF bomb1_state = 0
		OR bomb1_state = 3
			IF bomb3_state = 0
			OR bomb3_state = 3
				IF bomb4_state = 0
				OR bomb4_state = 3
					IF bomb2_state < 2
						IF LOCATE_CAR_3D rc_goblin_s3 current_bomb2_pickupx_s3 current_bomb2_pickupy_s3 current_bomb2_pickupz_s3 0.7 0.7 0.7 FALSE
						OR bomb2_state = 1
							
							GET_CAR_COORDINATES rc_goblin_s3 current_goblinx_s3 current_gobliny_s3 current_goblinz_s3
							PLACE_OBJECT_RELATIVE_TO_CAR timer_bomb2_s3 rc_goblin_s3 0.0 0.0 -0.4
						
							//start it on first bomb landing
							IF start_timer_on_first_hit = 0
								start_timer_on_first_hit = 1
								timer_s3 = 420000
							ENDIF

							SET_OBJECT_COLLISION timer_bomb2_s3 FALSE
							SET_OBJECT_DYNAMIC timer_bomb2_s3 FALSE

							GET_GROUND_Z_FOR_3D_COORD current_goblinx_s3 current_gobliny_s3 current_goblinz_s3 minimum_dist2_s3
					 		bomb2_ready = current_goblinz_s3 - minimum_dist2_s3


							IF bomb2_state = 0
								GOSUB add_target_blips_remove_bomb_blips
							ENDIF
							bomb2_state	= 1

							IF bomb2_state = 1
								IF bomb2_ready > 1.2 
									IF IS_IN_CAR_FIRE_BUTTON_PRESSED
										bomb2_state = 2
										SET_OBJECT_RECORDS_COLLISIONS timer_bomb2_s3 TRUE
										SET_OBJECT_DYNAMIC timer_bomb2_s3 TRUE
										SET_OBJECT_COLLISION timer_bomb2_s3 TRUE
										SORT_OUT_OBJECT_COLLISION_WITH_CAR timer_bomb2_s3 rc_goblin_s3
										//if +ve subtract from -0.6
										SET_OBJECT_VELOCITY timer_bomb2_s3 0.0 0.0 -1.0
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

//pickup bomb 3  
IF NOT IS_CAR_DEAD rc_goblin_s3
	IF IS_PLAYER_IN_REMOTE_MODE player1
		IF bomb1_state = 0
		OR bomb1_state = 3
			IF bomb2_state = 0
			OR bomb2_state = 3
				IF bomb4_state = 0
				OR bomb4_state = 3
					IF bomb3_state < 2
						IF LOCATE_CAR_3D rc_goblin_s3 current_bomb3_pickupx_s3 current_bomb3_pickupy_s3 current_bomb3_pickupz_s3 0.7 0.7 0.7 FALSE
						OR bomb3_state = 1
							
							GET_CAR_COORDINATES rc_goblin_s3 current_goblinx_s3 current_gobliny_s3 current_goblinz_s3
							PLACE_OBJECT_RELATIVE_TO_CAR timer_bomb3_s3 rc_goblin_s3 0.0 0.0 -0.4
							
							//start it on first bomb landing
							IF start_timer_on_first_hit = 0
								start_timer_on_first_hit = 1
								timer_s3 = 420000
							ENDIF
							
							SET_OBJECT_COLLISION timer_bomb3_s3 FALSE
							SET_OBJECT_DYNAMIC timer_bomb3_s3 FALSE

							GET_GROUND_Z_FOR_3D_COORD current_goblinx_s3 current_gobliny_s3 current_goblinz_s3 minimum_dist3_s3
					 		bomb3_ready = current_goblinz_s3 - minimum_dist3_s3

							IF bomb3_state = 0
								GOSUB add_target_blips_remove_bomb_blips
							ENDIF
							bomb3_state	= 1

							IF bomb3_state = 1
								IF bomb3_ready > 1.2 
									IF IS_IN_CAR_FIRE_BUTTON_PRESSED
										bomb3_state = 2
										SET_OBJECT_RECORDS_COLLISIONS timer_bomb3_s3 TRUE
										SET_OBJECT_DYNAMIC timer_bomb3_s3 TRUE
										SET_OBJECT_COLLISION timer_bomb3_s3 TRUE
										SORT_OUT_OBJECT_COLLISION_WITH_CAR timer_bomb3_s3 rc_goblin_s3
										SET_OBJECT_VELOCITY timer_bomb3_s3 0.0 0.0 -1.0
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




//pickup bomb 4  
IF NOT IS_CAR_DEAD rc_goblin_s3
	IF IS_PLAYER_IN_REMOTE_MODE player1
		IF bomb1_state = 0
		OR bomb1_state = 3
			IF bomb2_state = 0
			OR bomb2_state = 3
				IF bomb3_state = 0
				OR bomb3_state = 3
					IF bomb4_state < 2
						IF LOCATE_CAR_3D rc_goblin_s3 current_bomb4_pickupx_s3 current_bomb4_pickupy_s3 current_bomb4_pickupz_s3 0.7 0.7 0.7 FALSE
						OR bomb4_state = 1
							
							GET_CAR_COORDINATES rc_goblin_s3 current_goblinx_s3 current_gobliny_s3 current_goblinz_s3
							PLACE_OBJECT_RELATIVE_TO_CAR timer_bomb4_s3 rc_goblin_s3 0.0 0.0 -0.4
							
							//start it on first bomb landing
							IF start_timer_on_first_hit = 0
								start_timer_on_first_hit = 1
								timer_s3 = 420000
							ENDIF
							
							SET_OBJECT_COLLISION timer_bomb4_s3 FALSE
							SET_OBJECT_DYNAMIC timer_bomb4_s3 FALSE

							GET_GROUND_Z_FOR_3D_COORD current_goblinx_s3 current_gobliny_s3 current_goblinz_s3 minimum_dist4_s3
					 		bomb4_ready = current_goblinz_s3 - minimum_dist4_s3

							IF bomb4_state = 0
								GOSUB add_target_blips_remove_bomb_blips
							ENDIF
							bomb4_state	= 1

							IF bomb4_state = 1
								IF bomb4_ready > 1.2 
									IF IS_IN_CAR_FIRE_BUTTON_PRESSED
										bomb4_state = 2
										SET_OBJECT_RECORDS_COLLISIONS timer_bomb4_s3 TRUE
										SET_OBJECT_DYNAMIC timer_bomb4_s3 TRUE
										SET_OBJECT_COLLISION timer_bomb4_s3 TRUE
										SORT_OUT_OBJECT_COLLISION_WITH_CAR timer_bomb4_s3 rc_goblin_s3
										SET_OBJECT_VELOCITY timer_bomb4_s3 0.0 0.0 -1.0
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

//bring up location markers
IF player_in_van_for_first_time = 1

	IF NOT target1_hit = 1
		LOCATE_OBJECT_3D timer_bomb1_s3 target1x_s3 target1y_s3 target1z_s3 3.5 3.5 3.5 TRUE	
	ENDIF

	IF NOT target2_hit = 1
		LOCATE_OBJECT_3D timer_bomb1_s3 target2x_s3 target2y_s3 target2z_s3 3.5 3.5 3.5 TRUE
	ENDIF

	IF NOT target3_hit = 1
		LOCATE_OBJECT_3D timer_bomb1_s3 target3x_s3 target3y_s3 target3z_s3 3.5 3.5 3.5 TRUE
	ENDIF

	IF NOT target4_hit = 1
		LOCATE_OBJECT_3D timer_bomb1_s3 target4x_s3 target4y_s3 target4z_s3 3.5 3.5 3.5 TRUE
	ENDIF

ENDIF
											//////////////////////////////	BUILDERS IDLE ANIMS	//////////////////////////////////

IF NOT IS_CHAR_DEAD builder1
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder1attack = 0
			SET_CHAR_WAIT_STATE builder1 WAITSTATE_LOOK_ABOUT 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder2
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder2attack = 0
			SET_CHAR_WAIT_STATE builder2 WAITSTATE_USE_ATM 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder5
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder5attack = 0
			SET_CHAR_WAIT_STATE builder5 WAITSTATE_USE_ATM 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder6
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder6attack = 0
			SET_CHAR_WAIT_STATE builder6 WAITSTATE_USE_ATM 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder7
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder7attack = 0
			SET_CHAR_WAIT_STATE builder7 WAITSTATE_USE_ATM 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder9
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder9attack = 0
			SET_CHAR_WAIT_STATE builder9 WAITSTATE_LOOK_ABOUT 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder10
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder10attack = 0
			SET_CHAR_WAIT_STATE builder10 WAITSTATE_USE_ATM 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder11
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder11attack = 0
			SET_CHAR_WAIT_STATE builder11 WAITSTATE_USE_ATM 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder12
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder12attack = 0
			SET_CHAR_WAIT_STATE builder12 WAITSTATE_USE_ATM 300000
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder13
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF builder13attack = 0
			SET_CHAR_WAIT_STATE builder13 WAITSTATE_USE_ATM 300000
		ENDIF
	ENDIF
ENDIF





											//////////////////////////////	BUILDERS ATTACK COPTER	//////////////////////////////////



IF NOT IS_CHAR_DEAD builder1
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder1 rc_goblin_s3 7.0 7.0 6.0 FALSE
			SET_CHAR_WAIT_STATE builder1 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder1 rc_goblin_s3
			SET_CHAR_RUNNING builder1 TRUE
			builder1attack = 1
		ENDIF
	ENDIF
ENDIF 
 
IF NOT IS_CHAR_DEAD builder2
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder2 rc_goblin_s3 12.0 12.0 6.0 FALSE
			SET_CHAR_WAIT_STATE builder2 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder2 rc_goblin_s3
			SET_CHAR_RUNNING builder2 TRUE
			builder2attack = 1
		ENDIF
	ENDIF
ENDIF 

IF NOT IS_CHAR_DEAD builder3
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder3 rc_goblin_s3 10.0 10.0 3.0 FALSE
			SET_CHAR_WAIT_STATE builder3 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder3 rc_goblin_s3
			SET_CHAR_RUNNING builder3 TRUE
			builder3attack = 1
		ENDIF
	ENDIF
ENDIF 

IF NOT IS_CHAR_DEAD builder4
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder4 rc_goblin_s3 10.0 10.0 3.0 FALSE
			SET_CHAR_WAIT_STATE builder4 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder4 rc_goblin_s3
			SET_CHAR_RUNNING builder4 TRUE
		ENDIF
	ENDIF
ENDIF 

IF NOT IS_CHAR_DEAD builder5
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder5 rc_goblin_s3 7.0 7.0 5.0 FALSE
			SET_CHAR_WAIT_STATE builder5 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder5 rc_goblin_s3
			SET_CHAR_RUNNING builder5 TRUE
			builder5attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder6
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder6 rc_goblin_s3 15.0 15.0 4.0 FALSE
			SET_CHAR_WAIT_STATE builder6 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder6 rc_goblin_s3
			SET_CHAR_RUNNING builder6 TRUE
			builder6attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder7
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder7 rc_goblin_s3 15.0 15.0 3.0 FALSE
			SET_CHAR_WAIT_STATE builder7 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder7 rc_goblin_s3
			SET_CHAR_RUNNING builder7 TRUE
			builder7attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder8
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder8 rc_goblin_s3 15.0 15.0 6.0 FALSE
			SET_CHAR_WAIT_STATE builder8 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder8 rc_goblin_s3
			SET_CHAR_RUNNING builder8 TRUE
			builder8attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder9
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder9 rc_goblin_s3 18.0 18.0 3.0 FALSE
			SET_CHAR_WAIT_STATE builder9 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder9 rc_goblin_s3
			SET_CHAR_RUNNING builder9 TRUE
			builder9attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder10
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder10 rc_goblin_s3 15.0 15.0 6.0 FALSE
			SET_CHAR_WAIT_STATE builder10 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder10 rc_goblin_s3
			SET_CHAR_RUNNING builder10 TRUE
			builder10attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder11
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder11 rc_goblin_s3 15.0 15.0 4.0 FALSE
			SET_CHAR_WAIT_STATE builder11 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder11 rc_goblin_s3
			SET_CHAR_RUNNING builder11 TRUE
			builder11attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder12
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder12 rc_goblin_s3 15.0 15.0 6.0 FALSE
			SET_CHAR_WAIT_STATE builder12 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder12 rc_goblin_s3
			SET_CHAR_RUNNING builder12 TRUE
			builder12attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD builder13
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D builder13 rc_goblin_s3 10.0 10.0 4.0 FALSE
			SET_CHAR_WAIT_STATE builder13 WAITSTATE_FALSE 300
			SET_CHAR_OBJ_DESTROY_CAR builder13 rc_goblin_s3
			SET_CHAR_RUNNING builder13 TRUE
			builder13attack = 1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD security1_s3
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D security1_s3 rc_goblin_s3 18.0 18.0 3.0 FALSE
			SET_CHAR_OBJ_DESTROY_CAR security1_s3 rc_goblin_s3
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD security2_s3
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D security2_s3 rc_goblin_s3 18.0 18.0 3.0 FALSE
			SET_CHAR_OBJ_DESTROY_CAR security2_s3 rc_goblin_s3
			security2_s3attacked = 1	
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD security3_s3
	IF NOT IS_CAR_DEAD rc_goblin_s3 
		IF LOCATE_CHAR_ANY_MEANS_CAR_3D security3_s3 rc_goblin_s3 18.0 18.0 3.0 FALSE
			SET_CHAR_OBJ_DESTROY_CAR security3_s3 rc_goblin_s3
		ENDIF
	ENDIF
ENDIF



								//////////////////////////////	MISSION AUDIO	//////////////////////////////////


///////////////////////////////////////builder1

IF NOT IS_CHAR_DEAD builder1

	IF builder1attack = 1
		IF builder1played = 0
		
			IF playingaudio_s3 = 0
				playingaudio_s3 = 1
				playingaudio_s3state = 0
			ENDIF

		ENDIF
	ENDIF
	
	//playing what the...
	IF playingaudio_s3 = 1
	   	
		 IF playingaudio_s3state = 0
			 LOAD_MISSION_AUDIO 1 TEX3_2
			 playingaudio_s3state = 1
		 ELSE

			IF playingaudio_s3state = 1
				IF HAS_MISSION_AUDIO_LOADED 1
					playingaudio_s3state = 2
				ENDIF
			ENDIF

			IF playingaudio_s3state = 2
				GET_CHAR_COORDINATES builder1 x y z // SCFIX
				SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
		 		PLAY_MISSION_AUDIO 1
				playingaudio_s3state = 3
			ENDIF

			IF playingaudio_s3state = 3
				IF HAS_MISSION_AUDIO_FINISHED 1
					GET_CHAR_COORDINATES builder1 x y z // SCFIX
					SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
					playingaudio_s3state = 0
					playingaudio_s3 = 0
					CLEAR_MISSION_AUDIO 1
					builder1played = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
ELSE

	IF playingaudio_s3 = 1
		playingaudio_s3state = 0
		playingaudio_s3 = 0
		CLEAR_MISSION_AUDIO 1
		builder1played = 1
	ENDIF	

ENDIF



///////////////////////////////////////builder3

IF NOT IS_CHAR_DEAD builder3

	IF builder3attack = 1
		IF builder3played = 0
		
			IF playingaudio_s3 = 0
				playingaudio_s3 = 2
				playingaudio_s3state = 0
			ENDIF

		ENDIF
	ENDIF
	
	//playing what the was that...
	IF playingaudio_s3 = 2
	   	
		 IF playingaudio_s3state = 0
			 LOAD_MISSION_AUDIO 1 TEX3_1
			 playingaudio_s3state = 1
		 ELSE

			IF playingaudio_s3state = 1
				IF HAS_MISSION_AUDIO_LOADED 1
					playingaudio_s3state = 2
				ENDIF
			ENDIF

			IF playingaudio_s3state = 2
				GET_CHAR_COORDINATES builder3 x y z // SCFIX
				SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
		 		PLAY_MISSION_AUDIO 1
				playingaudio_s3state = 3
			ENDIF

			IF playingaudio_s3state = 3
				IF HAS_MISSION_AUDIO_FINISHED 1
					GET_CHAR_COORDINATES builder3 x y z // SCFIX
					SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
					playingaudio_s3state = 0
					playingaudio_s3 = 0
					CLEAR_MISSION_AUDIO 1
					builder3played = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
ELSE

	IF playingaudio_s3 = 2
		playingaudio_s3state = 0
		playingaudio_s3 = 0
		CLEAR_MISSION_AUDIO 1
		builder3played = 1
	ENDIF

ENDIF	
	
///////////////////////////////////////builder7

IF NOT IS_CHAR_DEAD builder7

	IF builder7attack = 1
		IF builder7played = 0
		
			IF playingaudio_s3 = 0
				playingaudio_s3 = 3
				playingaudio_s3state = 0
			ENDIF

		ENDIF
	ENDIF
	
	//playing want me to drill you
	IF playingaudio_s3 = 3
	   	
		 IF playingaudio_s3state = 0
			 LOAD_MISSION_AUDIO 1 TEX3_3
			 playingaudio_s3state = 1
		 ELSE

			IF playingaudio_s3state = 1
				IF HAS_MISSION_AUDIO_LOADED 1
					playingaudio_s3state = 2
				ENDIF
			ENDIF

			IF playingaudio_s3state = 2
				GET_CHAR_COORDINATES builder7 x y z // SCFIX
				SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
		 		PLAY_MISSION_AUDIO 1
				playingaudio_s3state = 3
			ENDIF

			IF playingaudio_s3state = 3
				IF HAS_MISSION_AUDIO_FINISHED 1
					GET_CHAR_COORDINATES builder7 x y z // SCFIX
					SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
					playingaudio_s3state = 0
					playingaudio_s3 = 0
					CLEAR_MISSION_AUDIO 1
					builder7played = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
ELSE

	IF playingaudio_s3 = 3
		playingaudio_s3state = 0
		playingaudio_s3 = 0
		CLEAR_MISSION_AUDIO 1
		builder7played = 1
	ENDIF

ENDIF	
	
///////////////////////////////////////builder13

IF NOT IS_CHAR_DEAD builder13

	IF builder13attack = 1
		IF builder13played = 0
		
			IF playingaudio_s3 = 0
				playingaudio_s3 = 4
				playingaudio_s3state = 0
			ENDIF

		ENDIF
	ENDIF
	
	//playing death destruction
	IF playingaudio_s3 = 4
	   	
		 IF playingaudio_s3state = 0
			 LOAD_MISSION_AUDIO 1 TEX3_4
			 playingaudio_s3state = 1
		 ELSE

			IF playingaudio_s3state = 1
				IF HAS_MISSION_AUDIO_LOADED 1
					playingaudio_s3state = 2
				ENDIF
			ENDIF

			IF playingaudio_s3state = 2
				GET_CHAR_COORDINATES builder13 x y z // SCFIX
				SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
		 		PLAY_MISSION_AUDIO 1
				playingaudio_s3state = 3
			ENDIF

			IF playingaudio_s3state = 3
				IF HAS_MISSION_AUDIO_FINISHED 1
					GET_CHAR_COORDINATES builder13 x y z // SCFIX
					SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
					playingaudio_s3state = 0
					playingaudio_s3 = 0
					CLEAR_MISSION_AUDIO 1
					builder13played = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
ELSE

	IF playingaudio_s3 = 4
		playingaudio_s3state = 0
		playingaudio_s3 = 0
		CLEAR_MISSION_AUDIO 1
		builder13played = 1
	ENDIF

ENDIF	
	
///////////////////////////////////////first security guard

IF NOT IS_CHAR_DEAD builder9

	IF builder9attack = 1
		IF builder9played = 0
		
			IF playingaudio_s3 = 0
				playingaudio_s3 = 5
				playingaudio_s3state = 0
			ENDIF

		ENDIF
	ENDIF
	
	//I gotta lay off those pills
	IF playingaudio_s3 = 5
	   	
		 IF playingaudio_s3state = 0
			 LOAD_MISSION_AUDIO 1 TEX3_8
			 playingaudio_s3state = 1
		 ELSE

			IF playingaudio_s3state = 1
				IF HAS_MISSION_AUDIO_LOADED 1
					playingaudio_s3state = 2
				ENDIF
			ENDIF

			IF playingaudio_s3state = 2
				GET_CHAR_COORDINATES builder9 x y z // SCFIX
				SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
		 		PLAY_MISSION_AUDIO 1
				playingaudio_s3state = 3
			ENDIF

			IF playingaudio_s3state = 3
				IF HAS_MISSION_AUDIO_FINISHED 1
					GET_CHAR_COORDINATES builder9 x y z // SCFIX
					SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
					playingaudio_s3state = 0
					playingaudio_s3 = 0
					CLEAR_MISSION_AUDIO 1
					builder9played = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
ELSE

	IF playingaudio_s3 = 5
		playingaudio_s3state = 0
		playingaudio_s3 = 0
		CLEAR_MISSION_AUDIO 1
		builder9played = 1
	ENDIF

ENDIF			

///////////////////////////////////////second security guard

IF NOT IS_CHAR_DEAD security2_s3

	IF security2_s3attacked = 1
		IF security2_s3played = 0
		
			IF playingaudio_s3 = 0
				playingaudio_s3 = 6
				playingaudio_s3state = 0
			ENDIF

		ENDIF
	ENDIF
	
	//some guy messing around i'll bust your toy
	IF playingaudio_s3 = 6
	   	
		 IF playingaudio_s3state = 0
			 LOAD_MISSION_AUDIO 1 TEX3_6
			 playingaudio_s3state = 1
		 ELSE

			IF playingaudio_s3state = 1
				IF HAS_MISSION_AUDIO_LOADED 1
					playingaudio_s3state = 2
				ENDIF
			ENDIF

			IF playingaudio_s3state = 2
				GET_CHAR_COORDINATES security2_s3 x y z // SCFIX
				SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
		 		PLAY_MISSION_AUDIO 1
				playingaudio_s3state = 3
			ENDIF

			IF playingaudio_s3state = 3
				IF HAS_MISSION_AUDIO_FINISHED 1
					GET_CHAR_COORDINATES security2_s3 x y z // SCFIX
					SET_MISSION_AUDIO_POSITION 1 x y z // SCFIX
					playingaudio_s3state = 0
					playingaudio_s3 = 0
					CLEAR_MISSION_AUDIO 1
					security2_s3played = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
ELSE

	IF playingaudio_s3 = 6
		playingaudio_s3state = 0
		playingaudio_s3 = 0
		CLEAR_MISSION_AUDIO 1
		security2_s3played = 1
	ENDIF

ENDIF		




										 //////////////////////////////	MISSION TIMER	//////////////////////////////////

//display on screen
IF start_timer_on_first_hit = 1
	IF NOT timer_s3 = 0
   		DISPLAY_ONSCREEN_TIMER_WITH_STRING timer_s3 TIMER_DOWN ( RACES ) //Time:
		PRINT_NOW ( TEX3_15 ) 7000 1
		start_timer_on_first_hit = 2
	ENDIF
ENDIF


										//////////////////////////////	MISSION BOMB TEXT	//////////////////////////////////



//printing messages "x more to go etc...."

//3 more to go
IF x_bombs_to_go = 0
	three_more_to_go1 = target1_hit + target2_hit 
	three_more_to_go2 = target3_hit + target4_hit
	three_more_to_go = three_more_to_go1 + three_more_to_go2
	IF  three_more_to_go = 1
		targets_to_go = 3   
		x_bombs_to_go = 1
		PRINT_NOW ( TEX3_12 ) 5000 2
	ENDIF
ENDIF

//2 more to go
IF x_bombs_to_go = 1
	two_more_to_go1 = target1_hit + target2_hit
	two_more_to_go2 = target3_hit + target4_hit
	two_more_to_go = two_more_to_go1 + two_more_to_go2
	IF	two_more_to_go = 2
		targets_to_go = 2	
		x_bombs_to_go = 2
		PRINT_NOW ( TEX3_13 ) 5000 2
	ENDIF
ENDIF
	
//1 more to go
IF x_bombs_to_go = 2
	one_more_to_go1 = target1_hit + target2_hit
	one_more_to_go2 = target3_hit + target4_hit
	one_more_to_go = one_more_to_go1 + one_more_to_go2
	IF	one_more_to_go = 3
		targets_to_go = 1 
		x_bombs_to_go = 3
		PRINT_NOW ( TEX3_14 ) 5000 2
	ENDIF
ENDIF
	

  

										//////////////////////////////	MISSION PASS/FAIL CONDITIONS	//////////////////////////////////

//mission passed
IF target1_hit = 1
AND target2_hit = 1
AND target3_hit = 1
AND target4_hit = 1

GOTO demolish_building

ENDIF


//mission failed - out of time
IF timer_s3 < 1
	IF start_timer_on_first_hit = 2
		PRINT_NOW ( TEX3_17 ) 5000 1
		GOTO mission_serg2_failed
	ENDIF
ENDIF
	
//mission failed - rcgoblin has been destroyed
IF IS_CAR_DEAD rc_goblin_s3
	IF player_in_van_for_first_time	= 1
		PRINT_NOW ( TEX3_18 ) 5000 2
		GOTO mission_serg2_failed
	ENDIF
ENDIF

//out of range
IF player_in_van_for_first_time = 1
	IF NOT IS_CAR_DEAD rc_goblin_s3
		IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 rc_goblin_s3 250.0 250.0 FALSE
			PRINT_NOW ( TEX3_21 ) 5000 1
			GOTO mission_serg2_failed
		ENDIF
	ENDIF
ENDIF

//bomb in water
IF player_in_van_for_first_time = 1
	IF IS_OBJECT_IN_WATER timer_bomb1_s3 
	OR IS_OBJECT_IN_WATER timer_bomb2_s3
	OR IS_OBJECT_IN_WATER timer_bomb3_s3
	OR IS_OBJECT_IN_WATER timer_bomb4_s3
		PRINT_NOW ( TEX3_19 ) 5000 1
		GOTO mission_serg2_failed
	ENDIF
ENDIF

//player destroys van before he gets in
IF player_in_van_for_first_time = 0
	IF vancreated_s3 = 1					
		IF IS_CAR_DEAD van_s3
			PRINT_NOW ( TEX3_31 ) 5000 1
			GOTO mission_serg2_failed
		ENDIF
	ENDIF
ENDIF


GOTO mission_serg2_loop

/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////	   Demolish Building		/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////

										
demolish_building:

CLEAR_ONSCREEN_TIMER timer_s3
CLEAR_ONSCREEN_COUNTER targets_to_go 

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF


MARK_MODEL_AS_NO_LONGER_NEEDED dynamite
MARK_MODEL_AS_NO_LONGER_NEEDED HAMMER
MARK_MODEL_AS_NO_LONGER_NEEDED barrel4
MARK_MODEL_AS_NO_LONGER_NEEDED GDa
MARK_MODEL_AS_NO_LONGER_NEEDED GDa

DELETE_CHAR builder1
DELETE_CHAR builder2
DELETE_CHAR builder3
DELETE_CHAR builder4
DELETE_CHAR builder5
DELETE_CHAR	builder6
DELETE_CHAR	builder7
DELETE_CHAR	builder8
DELETE_CHAR	builder9
DELETE_CHAR	builder10
DELETE_CHAR	security1_s3
DELETE_CHAR	security2_s3
DELETE_CHAR	security3_s3

IF NOT IS_CAR_DEAD van_s3
	FREEZE_CAR_POSITION van_s3 FALSE
ENDIF


SET_FIXED_CAMERA_POSITION 27.198 -352.651 12.977 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 28.1425 -352.8275 13.2567 JUMP_CUT

REQUEST_MODEL bldngst2meshdam

WHILE NOT HAS_MODEL_LOADED bldngst2meshdam
	WAIT 0
ENDWHILE

SHAKE_CAM 2500

ADD_EXPLOSION_NO_SOUND 69.420 -371.249 30.28 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 69.420 -371.249 30.28 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 69.420 -371.249 30.28 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 69.420 -371.249 30.28 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_HELI

ADD_EXPLOSION 71.554 -356.053 24.468 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_HELI

WAIT 10

SWAP_NEAREST_BUILDING_MODEL 117.991 -362.461 10.179 80.0 bldngst2mesh bldngst2meshdam

WAIT 250

ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_ROCKET	    
ADD_EXPLOSION 72.875 -360.392 23.922 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_MOLOTOV
ADD_EXPLOSION 71.554 -356.053 24.468 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 72.875 -361.392 23.922 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 72.875 -361.392 23.922 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 72.875 -361.392 23.922 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 73.180 -368.699 13.236 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 73.180 -368.699 13.236 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 73.180 -368.699 13.236 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 72.875 -361.392 23.922 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 72.875 -361.392 23.922 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 72.875 -361.392 23.922 EXPLOSION_HELI

WAIT 105
WAIT 105 

ADD_EXPLOSION_NO_SOUND 73.180 -368.699 13.236 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 73.180 -368.699 13.236 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 73.180 -368.699 13.236 EXPLOSION_MOLOTOV
ADD_EXPLOSION 73.180 -368.699 13.236 EXPLOSION_HELI

MARK_MODEL_AS_NO_LONGER_NEEDED bldngst2meshdam 

WAIT 105
WAIT 105 

ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_ROCKET	   
ADD_EXPLOSION 71.554 -354.053 24.468 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 69.420 -371.249 30.28 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 69.420 -371.249 30.28 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 69.420 -371.249 30.28 EXPLOSION_MOLOTOV
ADD_EXPLOSION 69.420 -371.249 30.28 EXPLOSION_HELI

WAIT 105

ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_ROCKET	   
ADD_EXPLOSION 73.180 -366.699 13.236 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 73.180 -366.699 13.236 16.0 0.0 0.1 5.0 0 0 0 11000	

WAIT 105 

ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 71.554 -356.053 24.468 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 69.420 -370.249 30.28 EXPLOSION_HELI

WAIT 300

ADD_EXPLOSION_NO_SOUND 72.875 -361.392 23.922 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 72.875 -361.392 23.922 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 72.875 -361.392 23.922 EXPLOSION_MOLOTOV
ADD_EXPLOSION 72.875 -361.392 23.922 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 69.420 -370.249 30.28 16.0 0.0 0.1 5.0 0 0 0 11000	

WAIT 105 

ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_ROCKET	    
ADD_EXPLOSION 71.554 -354.053 24.468 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 71.554 -354.053 24.468 EXPLOSION_HELI

WAIT 400

ADD_EXPLOSION 67.421 -374.562 25.85 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 67.421 -374.562 25.85 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 67.421 -374.562 25.85 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 67.421 -374.562 25.85 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 71.875 -360.392 30.092 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 71.875 -360.392 30.092 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 71.875 -360.392 30.092 EXPLOSION_HELI


WAIT 300

ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 73.180 -366.699 13.236 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_HELI

WAIT 300

ADD_EXPLOSION_NO_SOUND 69.224 -371.249 26.28 EXPLOSION_ROCKET	   
ADD_EXPLOSION 69.224 -371.249 26.28 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 69.224 -371.249 26.28 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 69.224 -371.249 26.28 16.0 0.0 0.1 5.0 0 0 0 5000	

WAIT 200 


ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_ROCKET	   
ADD_EXPLOSION 72.875 -360.392 23.922 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 72.875 -360.392 23.922 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 72.875 -360.392 23.922 16.0 0.0 0.1 5.0 0 0 0 5000	
WAIT 100


ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_ROCKET	  
ADD_EXPLOSION 73.180 -366.699 13.236 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 73.180 -366.699 13.236 EXPLOSION_HELI

WAIT 50

ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 71.554 -356.053 24.468 EXPLOSION_MOLOTOV
ADD_EXPLOSION 71.554 -356.053 24.468 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 71.554 -356.053 24.468 16.0 0.0 0.1 5.0 0 0 0 5000

WAIT 250

REQUEST_MODEL bldngst2mesh

WHILE NOT HAS_MODEL_LOADED bldngst2mesh
	WAIT 0
ENDWHILE

///////////////////////////////////////////////SECOND EXPLOSION

SWAP_NEAREST_BUILDING_MODEL 117.991 -362.461 10.179 80.0 bldngst2meshdam bldngst2mesh 
SET_FIXED_CAMERA_POSITION 95.427841 -431.41298 66.258308 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 96.135971 -430.912842 65.759521 JUMP_CUT
REMOVE_ALL_SCRIPT_FIRES


MARK_MODEL_AS_NO_LONGER_NEEDED bldngst2mesh 

REQUEST_MODEL bldngst2meshdam

WHILE NOT HAS_MODEL_LOADED bldngst2meshdam
	WAIT 0
ENDWHILE


SHAKE_CAM 2500

ADD_EXPLOSION_NO_SOUND 138.234 -398.796 49.419 EXPLOSION_ROCKET	   
ADD_EXPLOSION 138.234 -398.796 49.419 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 138.234 -398.796 49.419 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 146.365 -401.270 45.175 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 146.365 -401.270 45.175 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 146.365 -401.270 45.175 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 145.540 -400.172 32.071 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 145.540 -400.172 32.071 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 145.540 -400.172 32.071 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 145.540 -400.172 32.071 EXPLOSION_HELI

WAIT 105

ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_ROCKET	   
ADD_EXPLOSION 130.865 -399.556 45.108 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_HELI

WAIT 50

ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 138.234 -398.796 49.419 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 138.234 -398.796 49.419 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 138.234 -398.796 49.419 EXPLOSION_MOLOTOV
ADD_EXPLOSION 138.234 -398.796 49.419 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI

WAIT 105
WAIT 105 

ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 138.693 -399.751 45.107 EXPLOSION_ROCKET	   
ADD_EXPLOSION 138.693 -399.751 45.107 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 138.693 -399.751 45.107 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 139.529 -400.04 34.706 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 139.529 -397.04 34.706 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 139.529 -397.04 34.706 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 139.529 -397.04 34.706 EXPLOSION_HELI

ADD_EXPLOSION 135.62 -399.95996 41.42 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_ROCKET	   
ADD_EXPLOSION 140.531 -399.216644 26.636 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 139.529 -400.04 34.706 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 139.529 -397.04 34.706 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 139.529 -397.04 34.706 EXPLOSION_MOLOTOV
ADD_EXPLOSION 139.529 -397.04 34.706 EXPLOSION_HELI

SWAP_NEAREST_BUILDING_MODEL 117.991 -362.461 10.179 80.0 bldngst2mesh bldngst2meshdam
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 135.271 -390.00 31.704 16.0 0.0 0.1 5.0 0 0 0 11000

ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_MOLOTOV
ADD_EXPLOSION 135.271 -390.00 31.704 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_ROCKET	   
ADD_EXPLOSION 130.865 -399.556 45.108 EXPLOSION_HELI_BOMB
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_MOLOTOV  
ADD_EXPLOSION 130.865 -399.556 45.108 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 135.271 -390.00 31.704 16.0 0.0 0.1 5.0 0 0 0 11000

MARK_MODEL_AS_NO_LONGER_NEEDED bldngst2meshdam 

WAIT 105
WAIT 105 

ADD_EXPLOSION_NO_SOUND 138.693 -399.751 45.107 EXPLOSION_ROCKET	   
ADD_EXPLOSION 138.693 -399.751 45.107 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 138.693 -399.751 45.107 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 138.693 -399.751 45.107 EXPLOSION_HELI

WAIT 105

ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI

WAIT 105

WAIT 100

ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_ROCKET	   
ADD_EXPLOSION 135.62 -399.95996 41.42 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI

WAIT 250

ADD_EXPLOSION 140.531 -399.216644 26.636 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 139.529 -400.04 34.706 16.0 0.0 0.1 5.0 0 0 0 11000	

WAIT 105
WAIT 105 

ADD_EXPLOSION_NO_SOUND 138.234 -398.796 49.419 EXPLOSION_ROCKET	   
ADD_EXPLOSION 138.234 -398.796 49.419 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 138.234 -398.796 49.419 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 138.234 -398.796 49.419 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI

WAIT 105
WAIT 105 

WAIT 50

ADD_EXPLOSION_NO_SOUND 139.529 -400.04 34.706 EXPLOSION_ROCKET	   
ADD_EXPLOSION 139.529 -397.04 34.706 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 139.529 -397.04 34.706 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 139.529 -397.04 34.706 EXPLOSION_HELI

WAIT 250

ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.271 -390.00 31.704 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 130.865 -399.556 45.108 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_ROCKET	   
ADD_EXPLOSION 135.62 -399.95996 41.42 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 135.62 -399.95996 41.42 EXPLOSION_HELI

WAIT 50

ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 140.531 -399.216644 26.636 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 130.865 -399.556 45.108 16.0 0.0 0.1 5.0 0 0 0 5000	
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 139.529 -400.04 34.706 16.0 0.0 0.1 5.0 0 0 0 5000		

WAIT 100
////////////////////////////////////////////



///////////////////////////////////////////////THIRD EXPLOSION

REQUEST_MODEL bldngst2mesh

WHILE NOT HAS_MODEL_LOADED bldngst2mesh
	WAIT 0
ENDWHILE


SWAP_NEAREST_BUILDING_MODEL 117.991 -362.461 10.179 80.0 bldngst2meshdam bldngst2mesh 
SET_FIXED_CAMERA_POSITION 202.0835 -305.277 12.0866 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 201.496 -305.966 12.247 JUMP_CUT
REMOVE_ALL_SCRIPT_FIRES

MARK_MODEL_AS_NO_LONGER_NEEDED bldngst2mesh 


WAIT 750

ADD_EXPLOSION_NO_SOUND 168.166 -361.913 15.148 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 168.166 -366.913 15.206 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 164.8878 -340.893311 16.268 EXPLOSION_HELI

SHAKE_CAM 2000

ADD_EXPLOSION_NO_SOUND 168.166 -361.913 15.148 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 168.166 -366.913 15.206 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 164.8878 -340.893311 16.268 EXPLOSION_HELI

REQUEST_MODEL bldngst2meshdam

WHILE NOT HAS_MODEL_LOADED bldngst2meshdam
	WAIT 0
ENDWHILE

ADD_EXPLOSION_NO_SOUND 168.166 -361.913 15.148 EXPLOSION_ROCKET	   
ADD_EXPLOSION 168.166 -366.913 15.206 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 164.8878 -340.893311 16.268 EXPLOSION_HELI

WAIT 105 

ADD_EXPLOSION_NO_SOUND 168.166 -361.913 15.148 EXPLOSION_ROCKET	   
ADD_EXPLOSION 168.166 -366.913 15.206 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 167.0835 -350.057 16.283 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 164.8878 -340.893311 16.268 EXPLOSION_HELI

WAIT 50

ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_HELI

ADD_EXPLOSION 143.1712 -335.231 22.164 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 143.1712 -335.231 22.164 EXPLOSION_HELI_BOMB
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_MOLOTOV  
ADD_EXPLOSION_NO_SOUND 143.1712 -335.231 22.164 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_MOLOTOV
ADD_EXPLOSION 168.692 -336.464 19.678 EXPLOSION_HELI

SWAP_NEAREST_BUILDING_MODEL 117.991 -362.461 10.179 80.0 bldngst2mesh bldngst2meshdam

ADD_EXPLOSION 168.166 -361.913 15.148 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 168.166 -366.913 15.206 EXPLOSION_HELI_BOMB  

ADD_EXPLOSION_NO_SOUND 164.8878 -340.893311 16.268 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 168.166 -361.913 15.148 EXPLOSION_ROCKET	   
ADD_EXPLOSION 168.166 -366.913 15.206 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 167.0835 -350.057 16.283 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 164.8878 -340.893311 16.268 EXPLOSION_HELI

WAIT 50

ADD_EXPLOSION_NO_SOUND 168.477 -335.314 22.231 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 168.477 -335.314 22.231 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 168.477 -335.314 22.231 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 168.477 -335.314 22.231 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 169.708 -337.357 19.075 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 169.708 -337.357 19.075 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 169.708 -337.357 19.075 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 169.708 -351.357 18.075 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 169.708 -351.357 18.075 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 169.708 -351.357 18.075 EXPLOSION_MOLOTOV
ADD_EXPLOSION 169.708 -351.357 18.075 EXPLOSION_HELI

WAIT 105

WAIT 300

ADD_EXPLOSION_NO_SOUND 168.282 -335.453 18.769 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 168.282 -335.453 18.769 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 168.282 -335.453 18.769 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_MOLOTOV
ADD_EXPLOSION 168.692 -336.464 19.678 EXPLOSION_HELI

MARK_MODEL_AS_NO_LONGER_NEEDED bldngst2meshdam
 
WAIT 105

ADD_EXPLOSION_NO_SOUND 169.708 -351.357 18.075 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 169.708 -351.357 18.075 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 169.708 -351.357 18.075 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 169.708 -351.357 18.075 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 134.058 -335.45 22.873 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 134.058 -335.45 22.873 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 134.058 -335.45 22.873 EXPLOSION_HELI

WAIT 105

ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 158.365 -335.0422 21.805 EXPLOSION_HELI

WAIT 300

ADD_EXPLOSION_NO_SOUND 154.231 -335.0846 20.826 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 154.231 -335.0846 20.826 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 154.231 -335.0846 20.826 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 154.231 -335.0846 20.826 16.0 0.0 0.1 5.0 0 0 0 11000

ADD_EXPLOSION_NO_SOUND 169.335 -337.878 19.478 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 169.335 -337.878 19.478 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 169.335 -337.878 19.478 EXPLOSION_HELI

WAIT 500

ADD_EXPLOSION 164.531 -334.908 19.209 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 164.531 -334.908 19.209 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 164.531 -334.908 19.209 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 164.531 -334.908 19.209 EXPLOSION_HELI

WAIT 105
WAIT 105 
WAIT 105
WAIT 105 

ADD_EXPLOSION 168.692 -336.464 19.678 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 146.933 -331.328 23.657 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 146.933 -331.328 23.657 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 146.933 -331.328 23.657 EXPLOSION_HELI

WAIT 300

ADD_EXPLOSION 169.335 -337.878 19.478 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 169.335 -337.878 19.478 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 169.335 -337.878 19.478 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 168.282 -335.453 18.769 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 168.282 -335.453 18.769 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 168.282 -335.453 18.769 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 168.282 -335.453 18.769 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 168.282 -335.453 18.769 16.0 0.0 0.1 5.0 0 0 0 5000

WAIT 500

ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_ROCKET	   
ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_HELI

ADD_EXPLOSION_NO_SOUND 143.1712 -335.231 22.164 EXPLOSION_ROCKET	    
ADD_EXPLOSION 143.1712 -335.231 22.164 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 143.1712 -335.231 22.164 EXPLOSION_HELI

WAIT 500

ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 168.692 -336.464 19.678 EXPLOSION_HELI

WAIT 250

ADD_EXPLOSION_NO_SOUND 164.531 -334.908 19.209 EXPLOSION_ROCKET	    
ADD_EXPLOSION_NO_SOUND 164.531 -334.908 19.209 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION_NO_SOUND 164.531 -334.908 19.209 EXPLOSION_MOLOTOV
ADD_EXPLOSION_NO_SOUND 164.531 -334.908 19.209 EXPLOSION_HELI

WAIT 50

ADD_EXPLOSION_NO_SOUND 158.365 -335.0422 21.805 EXPLOSION_ROCKET	   
ADD_EXPLOSION 158.365 -335.0422 21.805 EXPLOSION_HELI_BOMB  
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 149.742294 -398.409 8.639 16.0 0.0 0.1 5.0 0 0 0 14000
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 168.692 -336.464 19.678 16.0 0.0 0.1 10.0 0 0 0 14000	
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 149.742294 -398.409 8.639 16.0 0.0 0.1 5.0 0 0 0 14000
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 169.335 -337.878 19.478 16.0 0.0 0.1 10.0 0 0 0 14000
WAIT 3500


GOTO mission_serg2_passed

//////////////////////////////////






// Mission Serg failed

mission_serg2_failed:
REMOVE_RC_BUGGY // SCFIX
ALTER_WANTED_LEVEL player1 wanted_level_s3
PRINT_BIG ( M_FAIL ) 2000 1

RETURN

   



//Mission Serg passed
mission_serg2_passed:

flag_sergio_mission2_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 1000
REGISTER_MISSION_PASSED TEX_3
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP sergio_contact_blip

// SCFIX: START
REMOVE_RC_BUGGY
WHILE NOT GET_FADING_STATUS // wait until the engine code starts the fade
	WAIT 0
ENDWHILE
WHILE GET_FADING_STATUS // wait while the fading is ongoing
	WAIT 0
ENDWHILE
// SCFIX: END

RETURN
		




							///////////////////////////////////////		GOSUB'S		/////////////////////////////////////

add_target_blips_remove_bomb_blips:


	IF NOT target1_hit = 1
		ADD_BLIP_FOR_COORD target1x_s3 target1y_s3 target1z_s3 target1_blip_s3
	ENDIF
		
	IF NOT target2_hit = 1
		ADD_BLIP_FOR_COORD target2x_s3 target2y_s3 target2z_s3 target2_blip_s3
	ENDIF

	IF NOT target3_hit = 1
		ADD_BLIP_FOR_COORD target3x_s3 target3y_s3 target3z_s3 target3_blip_s3
	ENDIF

	IF NOT target4_hit = 1
		ADD_BLIP_FOR_COORD target4x_s3 target4y_s3 target4z_s3 target4_blip_s3
	ENDIF

	REMOVE_BLIP timer_bomb1_blip_s3

	REMOVE_BLIP timer_bomb2_blip_s3
	
	REMOVE_BLIP timer_bomb3_blip_s3
	
	REMOVE_BLIP timer_bomb4_blip_s3
   
	PRINT_NOW ( TEX3_10 ) 2000 2//go drop it at a target

RETURN



add_bomb_blips_remove_target_blips:


	IF NOT bomb1_state = 3
		ADD_BLIP_FOR_OBJECT timer_bomb1_s3 timer_bomb1_blip_s3
	ENDIF

	IF NOT bomb2_state = 3
		ADD_BLIP_FOR_OBJECT timer_bomb2_s3 timer_bomb2_blip_s3
	ENDIF
	
	IF NOT bomb3_state = 3
		ADD_BLIP_FOR_OBJECT timer_bomb3_s3 timer_bomb3_blip_s3
	ENDIF

	IF NOT bomb4_state = 3
		ADD_BLIP_FOR_OBJECT timer_bomb4_s3 timer_bomb4_blip_s3			
	ENDIF

	REMOVE_BLIP target1_blip_s3
	
	REMOVE_BLIP	target2_blip_s3
	
	REMOVE_BLIP	target3_blip_s3
	
	REMOVE_BLIP	target4_blip_s3


RETURN


											/////////////////////// CHECK IF BOMBS HAVE HIT TARGET /////////////////////
																	  																	  
check_if_bomb1_has_hit_target:

//bomb1 checks
IF bomb1_state = 0
	
	//target 1
	IF target1_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb1_s3 target1x_s3 target1y_s3 target1z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target1x_s3 target1y_s3 target1z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb1_state = 3
			target1_hit = 1
			SET_OBJECT_COORDINATES timer_bomb1_s3 97.574 -381.658 9.2721
			SET_OBJECT_COLLISION timer_bomb1_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb1_s3 FALSE 
		ENDIF
	ENDIF

	//target 2
	IF target2_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb1_s3 target2x_s3 target2y_s3 target2z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target2x_s3 target2y_s3 target2z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb1_state = 3
			target2_hit = 1
			SET_OBJECT_COORDINATES timer_bomb1_s3 156.5491 -348.0284 18.1517
			SET_OBJECT_COLLISION timer_bomb1_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb1_s3 FALSE
		ENDIF
	ENDIF

	//target 3
	IF target3_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb1_s3 target3x_s3 target3y_s3 target3z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target3x_s3 target3y_s3 target3z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb1_state = 3
			target3_hit = 1
			SET_OBJECT_COORDINATES timer_bomb1_s3 88.1474 -361.8685 27.376
			SET_OBJECT_COLLISION timer_bomb1_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb1_s3 FALSE
		ENDIF
	ENDIF

	//target 4
	IF target4_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb1_s3 target4x_s3 target4y_s3 target4z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target4x_s3 target4y_s3 target4z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb1_state = 3
			target4_hit = 1
			SET_OBJECT_COORDINATES timer_bomb1_s3 140.0079 -383.1253 36.6172
			SET_OBJECT_COLLISION timer_bomb1_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb1_s3 FALSE
		ENDIF
	ENDIF

	//print you missed a target if player misses all targets when dropping bomb
	IF NOT bomb1_state = 3	
		PRINT_NOW ( TEX3_8 ) 3000 2
	ENDIF


ENDIF

RETURN



check_if_bomb2_has_hit_target:

//bomb2 checks
IF bomb2_state = 0
	
	//target 1
	IF target1_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb2_s3 target1x_s3 target1y_s3 target1z_s3 3.5 3.5 2.0 FALSE
		   	ADD_ONE_OFF_SOUND target1x_s3 target1y_s3 target1z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb2_state = 3
			target1_hit = 1
			SET_OBJECT_COORDINATES timer_bomb2_s3 97.574 -381.658 9.2721
			SET_OBJECT_COLLISION timer_bomb2_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb2_s3 FALSE 
		ENDIF
	ENDIF

	//target 2
	IF target2_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb2_s3 target2x_s3 target2y_s3 target2z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target2x_s3 target2y_s3 target2z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb2_state = 3
			target2_hit = 1
			SET_OBJECT_COORDINATES timer_bomb2_s3 156.5491 -348.0284 18.1517
			SET_OBJECT_COLLISION timer_bomb2_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb2_s3 FALSE
		ENDIF
	ENDIF

	//target 3
	IF target3_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb2_s3 target3x_s3 target3y_s3 target3z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target3x_s3 target3y_s3 target3z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb2_state = 3
			target3_hit = 1
			SET_OBJECT_COORDINATES timer_bomb2_s3 88.1474 -361.8685 27.376
			SET_OBJECT_COLLISION timer_bomb2_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb2_s3 FALSE
		ENDIF
	ENDIF

	//target 4
	IF target4_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb2_s3 target4x_s3 target4y_s3 target4z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target4x_s3 target4y_s3 target4z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb2_state = 3
			target4_hit = 1
			SET_OBJECT_COORDINATES timer_bomb2_s3 140.0079 -383.1253 36.6172
			SET_OBJECT_COLLISION timer_bomb2_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb2_s3 FALSE
		ENDIF
	ENDIF
			  
	//print you missed a target if player misses all targets when dropping bomb
	IF NOT bomb2_state = 3	
		PRINT_NOW ( TEX3_8 ) 3000 2
	ENDIF



ENDIF

RETURN


check_if_bomb3_has_hit_target:

//bomb3 checks
IF bomb3_state = 0
	
	//target 1
	IF target1_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb3_s3 target1x_s3 target1y_s3 target1z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target1x_s3 target1y_s3 target1z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb3_state = 3
			target1_hit = 1
			SET_OBJECT_COORDINATES timer_bomb3_s3 97.574 -381.658 9.2721
			SET_OBJECT_COLLISION timer_bomb3_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb3_s3 FALSE 
		ENDIF
	ENDIF

	//target 2
	IF target2_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb3_s3 target2x_s3 target2y_s3 target2z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target2x_s3 target2y_s3 target2z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb3_state = 3
			target2_hit = 1
			SET_OBJECT_COORDINATES timer_bomb3_s3 156.5491 -348.0284 18.1517
			SET_OBJECT_COLLISION timer_bomb3_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb3_s3 FALSE
		ENDIF
	ENDIF

	//target 3
	IF target3_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb3_s3 target3x_s3 target3y_s3 target3z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target3x_s3 target3y_s3 target3z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb3_state = 3
			target3_hit = 1
			SET_OBJECT_COORDINATES timer_bomb3_s3 88.1474 -361.8685 27.376
			SET_OBJECT_COLLISION timer_bomb3_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb3_s3 FALSE
		ENDIF
	ENDIF

	//target 4
	IF target4_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb3_s3 target4x_s3 target4y_s3 target4z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target4x_s3 target4y_s3 target4z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb3_state = 3
			target4_hit = 1
			SET_OBJECT_COORDINATES timer_bomb3_s3 140.0079 -383.1253 36.6172
			SET_OBJECT_COLLISION timer_bomb3_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb3_s3 FALSE
		ENDIF
	ENDIF

	//print you missed a target if player misses all targets when dropping bomb
	IF NOT bomb3_state = 3	
		PRINT_NOW ( TEX3_8 ) 3000 2
	ENDIF



ENDIF

RETURN


check_if_bomb4_has_hit_target:

//bomb4 checks
IF bomb4_state = 0
	
	//target 1
	IF target1_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb4_s3 target1x_s3 target1y_s3 target1z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target1x_s3 target1y_s3 target1z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb4_state = 3
			target1_hit = 1
			SET_OBJECT_COORDINATES timer_bomb4_s3 97.574 -381.658 9.2721
			SET_OBJECT_COLLISION timer_bomb4_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb4_s3 FALSE
		ENDIF
	ENDIF

	//target 2
	IF target2_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb4_s3 target2x_s3 target2y_s3 target2z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target2x_s3 target2y_s3 target2z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb4_state = 3
			target2_hit = 1
			SET_OBJECT_COORDINATES timer_bomb4_s3 156.5491 -348.0284 18.1517
			SET_OBJECT_COLLISION timer_bomb4_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb4_s3 FALSE
		ENDIF
	ENDIF

	//target 3
	IF target3_hit = 0																	 
		IF LOCATE_OBJECT_3D timer_bomb4_s3 target3x_s3 target3y_s3 target3z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target3x_s3 target3y_s3 target3z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb4_state = 3
			target3_hit = 1
			SET_OBJECT_COORDINATES timer_bomb4_s3 88.1474 -361.8685 27.376
			SET_OBJECT_COLLISION timer_bomb4_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb4_s3 FALSE
		ENDIF
	ENDIF

	//target 4
	IF target4_hit = 0
		IF LOCATE_OBJECT_3D timer_bomb4_s3 target4x_s3 target4y_s3 target4z_s3 3.5 3.5 2.0 FALSE
			ADD_ONE_OFF_SOUND target4x_s3 target4y_s3 target4z_s3 SOUND_IMRAN_ARM_BOMB
		   	bomb4_state = 3
			target4_hit = 1
			SET_OBJECT_COORDINATES timer_bomb4_s3 140.0079 -383.1253 36.6172
			SET_OBJECT_COLLISION timer_bomb4_s3 FALSE
			SET_OBJECT_DYNAMIC timer_bomb4_s3 FALSE
		ENDIF
	ENDIF

	//print you missed a target if player misses all targets when dropping bomb
	IF NOT bomb4_state = 3	
		PRINT_NOW ( TEX3_8 ) 3000 2
	ENDIF
		 
ENDIF

RETURN


// **************************************	mission cleanup
mission_cleanup_serg2:

flag_player_on_mission = 0
SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
//REMOVE_RC_BUGGY // SCFIX: moved to pass/fail

flag_player_on_rc_mission = 0 //PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX

REMOVE_BLIP vanblip_s3

REMOVE_BLIP target1_blip_s3
REMOVE_BLIP target2_blip_s3
REMOVE_BLIP target3_blip_s3
REMOVE_BLIP target4_blip_s3

REMOVE_BLIP timer_bomb1_blip_s3
REMOVE_BLIP timer_bomb2_blip_s3
REMOVE_BLIP timer_bomb3_blip_s3
REMOVE_BLIP timer_bomb4_blip_s3

DELETE_CHAR builder1
DELETE_CHAR builder2
DELETE_CHAR builder3
DELETE_CHAR builder4
DELETE_CHAR builder5
DELETE_CHAR	builder6
DELETE_CHAR builder7
DELETE_CHAR	builder8
DELETE_CHAR	builder9
DELETE_CHAR	builder10

CLEAR_ONSCREEN_TIMER timer_s3
CLEAR_ONSCREEN_COUNTER targets_to_go 

IF NOT IS_CAR_DEAD van_s3
	LOCK_CAR_DOORS van_s3 CARLOCK_UNLOCKED
ENDIF

SET_POLICE_IGNORE_PLAYER player1 OFF

IF NOT IS_CAR_DEAD van_s3
	FREEZE_CAR_POSITION van_s3 FALSE
ENDIF
 
DELETE_OBJECT timer_bomb1_s3
DELETE_OBJECT timer_bomb2_s3
DELETE_OBJECT timer_bomb3_s3
DELETE_OBJECT timer_bomb4_s3
 
DELETE_OBJECT dmbarrel1
DELETE_OBJECT dmbarrel2
DELETE_OBJECT dmbarrel3
DELETE_OBJECT dmbarrel4

MARK_MODEL_AS_NO_LONGER_NEEDED dynamite
MARK_MODEL_AS_NO_LONGER_NEEDED TOPFUN
MARK_MODEL_AS_NO_LONGER_NEEDED WMYCW
MARK_MODEL_AS_NO_LONGER_NEEDED HAMMER
MARK_MODEL_AS_NO_LONGER_NEEDED RCGoblin
MARK_MODEL_AS_NO_LONGER_NEEDED barrel2
MARK_MODEL_AS_NO_LONGER_NEEDED GDa
MARK_MODEL_AS_NO_LONGER_NEEDED colt45

SET_EVERYONE_IGNORE_PLAYER player1 OFF 
REMOVE_ALL_SCRIPT_FIRES 
MISSION_HAS_FINISHED

RETURN

}		



