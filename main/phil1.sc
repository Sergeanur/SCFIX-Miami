MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ************************************ phil 1**********************************************
// ************************************ Mexican Gun Runner**********************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME phil1										 
// Mission start stuff
GOSUB mission_start_phil1
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_phil1
ENDIF
GOSUB mission_cleanup_phil1
MISSION_END
// Variables for mission
//people, cars and objects
VAR_INT	mexican_car 
VAR_INT	mexican_car2 
VAR_INT	mexican_car3 
VAR_INT	mexican_car4 
VAR_INT	mexican_driver 
VAR_INT	mexican_driver2 
VAR_INT	mexican_driver3 
VAR_INT	mexican_driver4
VAR_INT	gungun1 
VAR_INT	gungun2 
VAR_INT	gungun3 
VAR_INT	gungun4 
VAR_INT press_moped1
VAR_INT press_moped2
VAR_INT press_moped3
VAR_INT press_moped4
VAR_INT press_driver1
VAR_INT press_driver2
VAR_INT press_driver3
VAR_INT press_driver4
VAR_INT mexican_gunner 
VAR_INT mexican_gunner1
VAR_INT box1
VAR_INT box2
VAR_INT box3
VAR_INT box4
VAR_INT fake_plyr_car
VAR_INT grenades_pickup

//blips
VAR_INT	mexican_car_blip 
VAR_INT	mexican_car2_blip 
VAR_INT	mexican_car3_blip 
VAR_INT	mexican_car4_blip 
VAR_INT	gun_blip1 
VAR_INT	gun_blip2 
VAR_INT	gun_blip3 
VAR_INT	gun_blip4 

//flags
VAR_INT gun_runner_goals
VAR_INT mexican_car_health
VAR_INT mexican_car_health2
VAR_INT mexican_car_health3
VAR_INT mexican_car_health4
VAR_INT gun1_collected
VAR_INT gun2_collected
VAR_INT gun3_collected
VAR_INT gun4_collected
VAR_INT create_gun1
VAR_INT create_gun2
VAR_INT create_gun3
VAR_INT create_gun4
VAR_INT weapon_dropped
VAR_INT attackers_coming_to_get_ya
VAR_INT flag_press1_moped_dead
VAR_INT flag_press2_moped_dead 
VAR_INT flag_press3_moped_dead 
VAR_INT flag_press4_moped_dead 
VAR_INT all_attackers_alive
VAR_INT press_driver1_off_moped
VAR_INT press_driver2_off_moped 
VAR_INT press_driver3_off_moped 
VAR_INT press_driver4_off_moped 
VAR_FLOAT mexican_car_speed
VAR_INT player1_got_all_guns
VAR_INT mexican_car_var
VAR_INT mexican_driver_var
VAR_INT driving_like_nutters_flag
VAR_INT weapon_knocked_from_back_of_truck_var   
VAR_INT weapon_knocked_from_back_of_truck1
VAR_INT weapon_knocked_from_back_of_truck2
VAR_INT weapon_knocked_from_back_of_truck3
VAR_INT weapon_knocked_from_back_of_truck4
VAR_INT no_car_blip1
VAR_INT no_car_blip2
VAR_INT no_car_blip3
VAR_INT no_car_blip4
VAR_INT first_time_trigger
VAR_INT killing_bonus  //NOT TO BE SET TO 0 (player will only be allowed to kill 10 moped guys to get bonus cash)
VAR_INT phil_speech1
VAR_INT phil_speech3
VAR_INT set_mission_truck1
VAR_INT set_mission_truck2
VAR_INT set_mission_truck3
VAR_INT set_mission_truck4
VAR_INT	set_mission_truck_var
VAR_INT gunner_attack
VAR_INT gunner1_attack
VAR_INT bomb_help_flag //NOT TO BE SET TO 0 
VAR_FLOAT groundz_box
			  



//coordinates
VAR_FLOAT mexican_car_x 
VAR_FLOAT mexican_car_y 
VAR_FLOAT mexican_car_z 
VAR_FLOAT mexican_car_stuck_x 
VAR_FLOAT mexican_car_stuck_y 
VAR_FLOAT mexican_car_stuck_z
VAR_FLOAT mex_warp_heading
VAR_FLOAT x_tem 
VAR_FLOAT y_tem
VAR_FLOAT sum_x_y_tem  
VAR_FLOAT mopedcoord_1_x 
VAR_FLOAT mopedcoord_1_y 
VAR_FLOAT mopedcoord_1_z 
VAR_FLOAT mopedcoord_2_x 
VAR_FLOAT mopedcoord_2_y
VAR_FLOAT moped_heading
VAR_FLOAT box1x 
VAR_FLOAT box1y 
VAR_FLOAT box1z
VAR_FLOAT box2x 
VAR_FLOAT box2y 
VAR_FLOAT box2z
VAR_FLOAT box3x 
VAR_FLOAT box3y 
VAR_FLOAT box3z
VAR_FLOAT box4x 
VAR_FLOAT box4y 
VAR_FLOAT box4z

//cutscene
VAR_INT cs_expltrk

// ****************************************Mission Start************************************
mission_start_phil1:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PHIL1 
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1004.5 311.1 9.9 155.7
//0 flags
gun_runner_goals = 0

mexican_car_health = 0
mexican_car_health2 = 0
mexican_car_health3 = 0
mexican_car_health4 = 0

gun1_collected = 0
gun2_collected = 0
gun3_collected = 0
gun4_collected = 0

create_gun1 = 2
create_gun2 = 2
create_gun3 = 2
create_gun4 = 2

weapon_dropped = 0
attackers_coming_to_get_ya = 0

flag_press1_moped_dead = 1
flag_press2_moped_dead = 1
flag_press3_moped_dead = 1
flag_press4_moped_dead = 1
all_attackers_alive = 0

press_driver1_off_moped = 0
press_driver2_off_moped = 0
press_driver3_off_moped = 0
press_driver4_off_moped = 0

mexican_car_speed = 0.0

player1_got_all_guns = 0

mexican_car_var = 0
mexican_driver_var = 0

driving_like_nutters_flag = 0

weapon_knocked_from_back_of_truck_var = 0
weapon_knocked_from_back_of_truck1 = 0
weapon_knocked_from_back_of_truck2 = 0
weapon_knocked_from_back_of_truck3 = 0
weapon_knocked_from_back_of_truck4 = 0

no_car_blip1 = 0
no_car_blip2 = 0
no_car_blip3 = 0
no_car_blip4 = 0

first_time_trigger = 0
phil_speech1 = 0
phil_speech3 = 0

set_mission_truck1 = 0
set_mission_truck2 = 0
set_mission_truck3 = 0
set_mission_truck4 = 0
set_mission_truck_var = 0
gunner_attack = 0
gunner1_attack = 0


//0.0 coords
player_x = 0.0  
player_y = 0.0 
player_z = 0.0 

mexican_car_x = 0.0 
mexican_car_y = 0.0 
mexican_car_z = 0.0

mexican_car_stuck_x = 0.0 
mexican_car_stuck_y = 0.0
mexican_car_stuck_z = 0.0

mex_warp_heading = 0.0

x_tem = 0.0 
y_tem = 0.0
sum_x_y_tem = 0.0 

mopedcoord_1_x = 0.0 
mopedcoord_1_y = 0.0 
mopedcoord_1_z = 0.0
mopedcoord_2_x = 0.0
mopedcoord_2_y = 0.0
moped_heading = 0.0

box1x = 0.0 
box1y = 0.0 
box1z = 0.0 
box2x = 0.0 
box2y = 0.0 
box2z = 0.0 
box3x = 0.0 
box3y = 0.0 
box3z = 0.0 
box4x = 0.0 
box4y = 0.0 
box4z = 0.0 

groundz_box = 0.0
{
// ****************************************START OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSphil

LOAD_SPECIAL_MODEL CUTOBJ01 expltrk

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

LOAD_CUTSCENE phil_1
SET_CUTSCENE_OFFSET -1099.62 327.21 10.23
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_phil
SET_CUTSCENE_ANIM cs_phil CSphil

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_expltrk
SET_CUTSCENE_ANIM cs_expltrk expltrk 

CLEAR_AREA -1098.8 342.6 10.2 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1098.8 342.6 10.2
SET_PLAYER_HEADING player1 265.8

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2823  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW PHIL1_A 10000 1 // Phil?

WHILE cs_time < 3522
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_B 10000 1 // RUN!

WHILE cs_time < 5525
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_C 10000 1 // Run

WHILE cs_time < 8000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED 
	ADD_EXPLOSION -1091.6 327.6 10.5 EXPLOSION_ROCKET      
	ADD_EXPLOSION -1091.6 327.6 10.5 EXPLOSION_HELI_BOMB  
	ADD_EXPLOSION -1091.6 327.6 10.5 EXPLOSION_MOLOTOV
	ADD_EXPLOSION -1091.6 327.6 10.5 EXPLOSION_HELI
ENDIF

WHILE cs_time < 13868
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_O 10000 1 // Hoooooweeeeee! 

WHILE cs_time < 17669
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_D 10000 1 // Never get a naked flame too close to one of Phil Cassidy's Boomshine stills!

WHILE cs_time < 23022
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_E 10000 1 // Shit Phil, you drink that stuff?

WHILE cs_time < 25871
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_F 10000 1 // Hell, you don't have to drink it

WHILE cs_time < 28447
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_G 10000 1 // - just a good whiff will set you off.

WHILE cs_time < 30702
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_H 10000 1 // Listen Phil, you said you could sort me with some firepower...

WHILE cs_time < 34919
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_I 10000 1 // Sure thing.
  
WHILE cs_time < 36645
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_J 10000 1 // There's some Mexican gun-runner been doing me for business of late.

WHILE cs_time < 41023
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_K 10000 1 //He does his weekly run about now.

WHILE cs_time < 45336
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_L 10000 1 //Ram his hardware off the back of his trucks before he goes to ground.

WHILE cs_time < 49603
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_M 10000 1 //and you'd be doing me a favour while you're at it.

WHILE cs_time < 52389
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PHIL1_N 10000 1 //then finish him off.

WHILE cs_time < 53589
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
   
CLEAR_PRINTS

WHILE cs_time < 54400
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
//------------------REQUEST_MODELS------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

REQUEST_MODEL walton
REQUEST_MODEL WMYCR
REQUEST_MODEL faggio
REQUEST_MODEL gunbox
REQUEST_MODEL patriot

WHILE NOT HAS_MODEL_LOADED walton
OR NOT HAS_MODEL_LOADED WMYCR
OR NOT HAS_MODEL_LOADED faggio
OR NOT HAS_MODEL_LOADED gunbox
OR NOT HAS_MODEL_LOADED patriot
	WAIT 0
ENDWHILE

REQUEST_MODEL python
REQUEST_MODEL shotgspa
REQUEST_MODEL ingramsl
REQUEST_MODEL M60
REQUEST_MODEL uzi

WHILE NOT HAS_MODEL_LOADED python
OR NOT HAS_MODEL_LOADED shotgspa
OR NOT HAS_MODEL_LOADED ingramsl
OR NOT HAS_MODEL_LOADED M60
OR NOT HAS_MODEL_LOADED uzi
	WAIT 0
ENDWHILE

LOAD_MISSION_AUDIO 1 PHIL1_2
LOAD_MISSION_AUDIO 2 PHIL1_3

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 


PRINT_NOW ( PHI1_01 ) 11000 1 //Go and knock the arms of the back of the dealers trucks

SET_ENTER_CAR_RANGE_MULTIPLIER 3.0

CREATE_CAR patriot -1073.4 325.3 10.2 fake_plyr_car
SET_CAR_HEADING fake_plyr_car 259.7 
CREATE_PICKUP_WITH_AMMO bomb PICKUP_ONCE 15 -1058.6 325.9 11.2 grenades_pickup


DO_FADE 1500 FADE_IN

//creating mexican gun runner cars
//car1 at back
CREATE_CAR walton -757.6 23.9 9.9 mexican_car
CHANGE_CAR_COLOUR mexican_car CARCOLOUR_WHITE CARCOLOUR_WHITE 
SET_CAR_AVOID_LEVEL_TRANSITIONS mexican_car TRUE
SET_CAR_WATERTIGHT mexican_car TRUE
CREATE_CHAR_INSIDE_CAR mexican_car PEDTYPE_CIVMALE WMYCR mexican_driver
SET_CAR_CRUISE_SPEED mexican_car 15.0  
SET_CAR_DRIVING_STYLE mexican_car 2
CAR_WANDER_RANDOMLY mexican_car
SET_CAR_AVOID_LEVEL_TRANSITIONS mexican_car TRUE 
ADD_BLIP_FOR_CAR mexican_car mexican_car_blip

CREATE_OBJECT gunbox -757.6 23.9 10.0 box1
SET_OBJECT_COLLISION box1 FALSE
CREATE_CHAR PEDTYPE_GANG_SECURITY WMYCR -757.6 23.9 10.0 mexican_gunner
SET_CHAR_THREAT_SEARCH mexican_gunner THREAT_GANG_HAITIAN
SET_CHAR_THREAT_SEARCH mexican_gunner THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH mexican_gunner THREAT_COP
ATTACH_CHAR_TO_CAR mexican_gunner mexican_car 0.0 -1.0 0.9 FACING_BACK 45.0 WEAPONTYPE_UZI 

//car2
CREATE_CAR walton -763.6 12.9 9.9 mexican_car2
CHANGE_CAR_COLOUR mexican_car2 CARCOLOUR_WHITE CARCOLOUR_WHITE 
SET_CAR_AVOID_LEVEL_TRANSITIONS mexican_car2 TRUE
SET_CAR_WATERTIGHT mexican_car2 TRUE
CREATE_CHAR_INSIDE_CAR mexican_car2 PEDTYPE_CIVMALE WMYCR mexican_driver2
SET_CAR_CRUISE_SPEED mexican_car2 15.0
SET_CAR_DRIVING_STYLE mexican_car2 2
CAR_WANDER_RANDOMLY mexican_car2
SET_CAR_AVOID_LEVEL_TRANSITIONS mexican_car2 TRUE 
ADD_BLIP_FOR_CAR mexican_car2 mexican_car2_blip

CREATE_OBJECT gunbox -763.6 12.9 10.0 box2
SET_OBJECT_COLLISION box2 FALSE

//car3
CREATE_CAR walton -674.9 788.4 10.3 mexican_car3
CHANGE_CAR_COLOUR mexican_car3 CARCOLOUR_WHITE CARCOLOUR_WHITE 
SET_CAR_AVOID_LEVEL_TRANSITIONS mexican_car3 TRUE
SET_CAR_WATERTIGHT mexican_car3 TRUE

CREATE_CHAR_INSIDE_CAR mexican_car3 PEDTYPE_CIVMALE WMYCR mexican_driver3


SET_CAR_CRUISE_SPEED mexican_car3 15.0
SET_CAR_DRIVING_STYLE mexican_car3 2
CAR_WANDER_RANDOMLY mexican_car3
SET_CAR_AVOID_LEVEL_TRANSITIONS mexican_car3 TRUE 
ADD_BLIP_FOR_CAR mexican_car3 mexican_car3_blip
CREATE_CHAR PEDTYPE_GANG_SECURITY WMYCR -674.9 788.4 10.3 mexican_gunner1
SET_CHAR_THREAT_SEARCH mexican_gunner1 THREAT_GANG_HAITIAN
SET_CHAR_THREAT_SEARCH mexican_gunner1 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH mexican_gunner1 THREAT_COP
ATTACH_CHAR_TO_CAR mexican_gunner1 mexican_car3 0.0 -1.0 0.9 FACING_BACK 45.0 WEAPONTYPE_UZI 

CREATE_OBJECT gunbox -674.9 788.4 10.3 box3
SET_OBJECT_COLLISION box3 FALSE

//car4
CREATE_CAR walton -674.9 777.1 10.3 mexican_car4
CHANGE_CAR_COLOUR mexican_car4 CARCOLOUR_WHITE CARCOLOUR_WHITE 
SET_CAR_AVOID_LEVEL_TRANSITIONS mexican_car4 TRUE
SET_CAR_WATERTIGHT mexican_car4 TRUE
CREATE_CHAR_INSIDE_CAR mexican_car4 PEDTYPE_CIVMALE WMYCR mexican_driver4
SET_CAR_CRUISE_SPEED mexican_car4 15.0
SET_CAR_DRIVING_STYLE mexican_car4 2
CAR_WANDER_RANDOMLY mexican_car4
SET_CAR_AVOID_LEVEL_TRANSITIONS mexican_car4 TRUE 
ADD_BLIP_FOR_CAR mexican_car4 mexican_car4_blip


CREATE_OBJECT gunbox -674.9 777.1 10.3 box4
SET_OBJECT_COLLISION box4 FALSE

//impossible IF statement - IGNORE
GOTO phil1_fool_compiler // FIXMIAMI: remove flag_player_on_mission = 0 check
	CREATE_CAR faggio -844.0 -325.0 10.0 press_moped1  
	CREATE_CHAR_INSIDE_CAR press_moped1 PEDTYPE_CIVMALE WMYCR press_driver1
	CREATE_CAR faggio -844.0 -325.0 10.0 press_moped2  
	CREATE_CHAR_INSIDE_CAR press_moped2 PEDTYPE_CIVMALE WMYCR press_driver2
	CREATE_CAR faggio -844.0 -325.0 10.0 press_moped3  
	CREATE_CHAR_INSIDE_CAR press_moped3 PEDTYPE_CIVMALE WMYCR press_driver3
	CREATE_CAR faggio -844.0 -325.0 10.0 press_moped4  
	CREATE_CHAR_INSIDE_CAR press_moped4 PEDTYPE_CIVMALE WMYCR press_driver4
phil1_fool_compiler: // FIXMIAMI: remove flag_player_on_mission = 0 check

//DISPLAY_ONSCREEN_COUNTER mexican_car_health COUNTER_DISPLAY_NUMBER

gun_runner_loop:///////////////////////////////////////////////////////////////////////////////////////////////////////
												   
WAIT 0
		
IF HAS_PICKUP_BEEN_COLLECTED grenades_pickup
	IF bomb_help_flag = 0
		PRINT_HELP ( PHI1_HP ) //When using Detonator Grenades, throw a grenade then trigger the explosion at any time.
		bomb_help_flag = 1
	ENDIF
ENDIF


//waiting till player1 damages cars enough to knock out weapons
IF gun_runner_goals = 0

	IF player1_got_all_guns = 4
		IF NOT IS_CAR_DEAD mexican_car
			REMOVE_BLIP mexican_car_blip 
			ADD_BLIP_FOR_CAR mexican_car mexican_car_blip
		ENDIF
		IF NOT IS_CAR_DEAD mexican_car2
			REMOVE_BLIP mexican_car2_blip 
			ADD_BLIP_FOR_CAR mexican_car2 mexican_car2_blip
		ENDIF
		IF NOT IS_CAR_DEAD mexican_car3
			REMOVE_BLIP mexican_car3_blip 
			ADD_BLIP_FOR_CAR mexican_car3 mexican_car3_blip
		ENDIF
		IF NOT IS_CAR_DEAD mexican_car4
			REMOVE_BLIP mexican_car4_blip 
			ADD_BLIP_FOR_CAR mexican_car4 mexican_car4_blip
		ENDIF
		PRINT_NOW ( PHI1_04 ) 11000 1 //Now go and finish off the remaining arms dealers
		gun_runner_goals = 1
	ENDIF
		
	IF NOT IS_CAR_DEAD mexican_car
		IF create_gun1 = 2
			PLACE_OBJECT_RELATIVE_TO_CAR box1 mexican_car 0.0 -2.0 0.3  
		ENDIF
		GET_CAR_HEALTH mexican_car mexican_car_health
		IF create_gun1 = 2						 
			IF mexican_car_health < 970
			OR IS_PLAYER_IN_CAR player1 mexican_car
			OR HAS_OBJECT_BEEN_DAMAGED box1 
				IF weapon_knocked_from_back_of_truck1 = 0
					weapon_knocked_from_back_of_truck1 = 1
				ENDIF	 
				IF gun1_collected = 0
					GOSUB removing_car_blips
					PLACE_OBJECT_RELATIVE_TO_CAR box1 mexican_car 0.0 -2.0 0.8
					SET_OBJECT_COLLISION box1 TRUE
					SET_OBJECT_DYNAMIC box1 TRUE
					ADD_TO_OBJECT_VELOCITY box1 0.0 0.0 3.0
					//MAKE_OBJECT_TARGETTABLE box1  
					ADD_BLIP_FOR_OBJECT box1 gun_blip1
					PRINT_NOW ( PHI1_02 ) 7000 1 //The arms dealer dropped his load.  Smash the crate and pick up the weapon.
					create_gun1 = 0
					
				ENDIF
			ENDIF
		ENDIF
		IF mexican_car_health < 300
			IF NOT IS_CHAR_DEAD mexican_gunner
				DETACH_CHAR_FROM_CAR mexican_gunner
				IF gunner_attack = 0
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_gunner player1
					gunner_attack = 1
				ENDIF 
			ENDIF
			IF NOT IS_CHAR_DEAD mexican_driver
				IF IS_CHAR_IN_CAR mexican_driver mexican_car  
					SET_CHAR_OBJ_LEAVE_CAR mexican_driver mexican_car
				ENDIF
			ENDIF
		ENDIF   
	ELSE
		IF create_gun1 = 2						 
			IF weapon_knocked_from_back_of_truck1 = 0
				weapon_knocked_from_back_of_truck1 = 1
			ENDIF	 
			IF gun1_collected = 0
				GOSUB removing_car_blips
				SET_OBJECT_COLLISION box1 TRUE
				SET_OBJECT_DYNAMIC box1 TRUE
				ADD_TO_OBJECT_VELOCITY box1 0.0 0.0 3.0
				//MAKE_OBJECT_TARGETTABLE box1  
				ADD_BLIP_FOR_OBJECT box1 gun_blip1
				PRINT_NOW ( PHI1_02 ) 7000 1 //The arms dealer dropped his load.  Smash the crate and pick up the weapon.
				create_gun1 = 0

			ENDIF  
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD mexican_car2
		IF create_gun2 = 2
			PLACE_OBJECT_RELATIVE_TO_CAR box2 mexican_car2 0.0 -2.0 0.3  
		ENDIF
		GET_CAR_HEALTH mexican_car2 mexican_car_health2
		IF create_gun2 = 2
			IF mexican_car_health2 < 970
			OR IS_PLAYER_IN_CAR player1 mexican_car2 
			OR HAS_OBJECT_BEEN_DAMAGED box2 
				IF weapon_knocked_from_back_of_truck2 = 0
					weapon_knocked_from_back_of_truck2 = 1
				ENDIF	 
				IF gun2_collected = 0
					GOSUB removing_car_blips
					PLACE_OBJECT_RELATIVE_TO_CAR box2 mexican_car2 0.0 -2.0 0.8
					SET_OBJECT_COLLISION box2 TRUE
					SET_OBJECT_DYNAMIC box2 TRUE
					ADD_TO_OBJECT_VELOCITY box2 0.0 0.0 3.0 
					//MAKE_OBJECT_TARGETTABLE box2  
					ADD_BLIP_FOR_OBJECT box2 gun_blip2  
					PRINT_NOW ( PHI1_02 ) 7000 1 //The arms dealer dropped his load.  Smash the crate and pick up the weapon.
					create_gun2 = 0

				ENDIF
			ENDIF
		ENDIF
		IF mexican_car_health2 < 300
			IF NOT IS_CHAR_DEAD mexican_driver2
				IF IS_CHAR_IN_CAR mexican_driver2 mexican_car2  
					SET_CHAR_OBJ_LEAVE_CAR mexican_driver2 mexican_car2
				ENDIF
			ENDIF
		ENDIF   
	ELSE
		IF create_gun2 = 2
			IF weapon_knocked_from_back_of_truck2 = 0
				weapon_knocked_from_back_of_truck2 = 1
			ENDIF	 
			IF gun2_collected = 0
				GOSUB removing_car_blips
				SET_OBJECT_COLLISION box2 TRUE
				SET_OBJECT_DYNAMIC box2 TRUE
				ADD_TO_OBJECT_VELOCITY box2 0.0 0.0 3.0 
				//MAKE_OBJECT_TARGETTABLE box2  
				ADD_BLIP_FOR_OBJECT box2 gun_blip2  
				PRINT_NOW ( PHI1_02 ) 7000 1 //The arms dealer dropped his load.  Smash the crate and pick up the weapon.
				create_gun2 = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD mexican_car3
		IF create_gun3 = 2
			PLACE_OBJECT_RELATIVE_TO_CAR box3 mexican_car3 0.0 -2.0 0.3  
		ENDIF
		GET_CAR_HEALTH mexican_car3 mexican_car_health3
		IF create_gun3 = 2
			IF mexican_car_health3 < 970
			OR IS_PLAYER_IN_CAR player1 mexican_car3 
			OR HAS_OBJECT_BEEN_DAMAGED box3 
				IF weapon_knocked_from_back_of_truck3 = 0
					weapon_knocked_from_back_of_truck3 = 1
				ENDIF	 
				IF gun3_collected = 0
					GOSUB removing_car_blips
					PLACE_OBJECT_RELATIVE_TO_CAR box3 mexican_car3 0.0 -2.0 0.8
					SET_OBJECT_COLLISION box3 TRUE
					SET_OBJECT_DYNAMIC box3 TRUE
					ADD_TO_OBJECT_VELOCITY box3 0.0 0.0 3.0 
					//MAKE_OBJECT_TARGETTABLE box3  
					ADD_BLIP_FOR_OBJECT box3 gun_blip3  
					PRINT_NOW ( PHI1_02 ) 7000 1 //The arms dealer dropped his load.  Smash the crate and pick up the weapon.
					create_gun3 = 0
				ENDIF
			ENDIF
		ENDIF
		IF mexican_car_health3 < 300
			IF NOT IS_CHAR_DEAD mexican_gunner1
				DETACH_CHAR_FROM_CAR mexican_gunner1
				IF gunner1_attack = 0
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_gunner1 player1 
					gunner1_attack = 1
				ENDIF
			ENDIF 
			IF NOT IS_CHAR_DEAD mexican_driver3
				IF IS_CHAR_IN_CAR mexican_driver3 mexican_car3  
					SET_CHAR_OBJ_LEAVE_CAR mexican_driver3 mexican_car3
				ENDIF
			ENDIF
		ENDIF   
	ELSE
		IF create_gun3 = 2
			IF weapon_knocked_from_back_of_truck3 = 0
				weapon_knocked_from_back_of_truck3 = 1
			ENDIF	 
			IF gun3_collected = 0
				GOSUB removing_car_blips
				SET_OBJECT_COLLISION box3 TRUE
				SET_OBJECT_DYNAMIC box3 TRUE
				ADD_TO_OBJECT_VELOCITY box3 0.0 0.0 3.0 
				//MAKE_OBJECT_TARGETTABLE box3  
				ADD_BLIP_FOR_OBJECT box3 gun_blip3  
				PRINT_NOW ( PHI1_02 ) 7000 1 //The arms dealer dropped his load.  Smash the crate and pick up the weapon.
				create_gun3 = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD mexican_car4
		IF create_gun4 = 2
			PLACE_OBJECT_RELATIVE_TO_CAR box4 mexican_car4 0.0 -2.0 0.3  
		ENDIF
		GET_CAR_HEALTH mexican_car4 mexican_car_health4
		IF create_gun4 = 2
			IF mexican_car_health4 < 970
			OR IS_PLAYER_IN_CAR player1 mexican_car4 
			OR HAS_OBJECT_BEEN_DAMAGED box4 
				IF weapon_knocked_from_back_of_truck4 = 0
					weapon_knocked_from_back_of_truck4 = 1
				ENDIF	 
				IF gun4_collected = 0
					GOSUB removing_car_blips
					PLACE_OBJECT_RELATIVE_TO_CAR box4 mexican_car4 0.0 -2.0 0.8
					SET_OBJECT_COLLISION box4 TRUE
					SET_OBJECT_DYNAMIC box4 TRUE
					ADD_TO_OBJECT_VELOCITY box4 0.0 0.0 3.0 
					//MAKE_OBJECT_TARGETTABLE box4  
					ADD_BLIP_FOR_OBJECT box4 gun_blip4  
					PRINT_NOW ( PHI1_02 ) 7000 1 //The arms dealer dropped his load.  Smash the crate and pick up the weapon.
					create_gun4 = 0
				ENDIF
			ENDIF
		ENDIF
		IF mexican_car_health4 < 300
			IF NOT IS_CHAR_DEAD mexican_driver4
				IF IS_CHAR_IN_CAR mexican_driver4 mexican_car4  
					SET_CHAR_OBJ_LEAVE_CAR mexican_driver4 mexican_car4
				ENDIF
			ENDIF
		ENDIF   
	ELSE
		IF create_gun4 = 2
			IF weapon_knocked_from_back_of_truck4 = 0
				weapon_knocked_from_back_of_truck4 = 1
			ENDIF	 
			IF gun4_collected = 0
				GOSUB removing_car_blips
				SET_OBJECT_COLLISION box4 TRUE
				SET_OBJECT_DYNAMIC box4 TRUE
				ADD_TO_OBJECT_VELOCITY box4 0.0 0.0 3.0 
				//MAKE_OBJECT_TARGETTABLE box4  
				ADD_BLIP_FOR_OBJECT box4 gun_blip4  
				PRINT_NOW ( PHI1_02 ) 7000 1 //The arms dealer dropped his load.  Smash the crate and pick up the weapon.
				create_gun4 = 0
			ENDIF
		ENDIF
	ENDIF


//setting guys on back of trucks to kill player
	IF weapon_knocked_from_back_of_truck1 = 1
	OR weapon_knocked_from_back_of_truck2 = 1
	OR weapon_knocked_from_back_of_truck3 = 1
	OR weapon_knocked_from_back_of_truck4 = 1
		MARK_CAR_AS_NO_LONGER_NEEDED fake_plyr_car
		IF NOT IS_CHAR_DEAD mexican_gunner 
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_gunner player1
		ENDIF
		IF NOT IS_CHAR_DEAD mexican_gunner1 
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_gunner1 player1
		ENDIF
		IF driving_like_nutters_flag = 0
			driving_like_nutters_flag = 1
		ENDIF
	ENDIF

//dropping weapons
	IF gun1_collected = 0
		IF create_gun1 = 0
			IF NOT HAS_OBJECT_BEEN_DAMAGED box1 
				GET_OBJECT_COORDINATES box1 box1x box1y box1z
				GET_GROUND_Z_FOR_3D_COORD box1x box1y box1z groundz_box
				IF groundz_box > 9.0
					groundz_box += 1.0
					box1z = groundz_box
				ENDIF	
			ELSE
				CREATE_PICKUP python PICKUP_ONCE box1x box1y box1z gungun1
				REMOVE_BLIP gun_blip1 
				ADD_BLIP_FOR_PICKUP gungun1 gun_blip1 
				MARK_OBJECT_AS_NO_LONGER_NEEDED box1 
				create_gun1 = 1
				weapon_dropped ++
			ENDIF
		ENDIF
	ENDIF

	IF gun2_collected = 0
		IF create_gun2 = 0
			IF NOT HAS_OBJECT_BEEN_DAMAGED box2 
				GET_OBJECT_COORDINATES box2 box2x box2y box2z
				GET_GROUND_Z_FOR_3D_COORD box2x box2y box2z groundz_box
				IF groundz_box > 9.0
					groundz_box += 1.0
					box2z = groundz_box
				ENDIF	
			ELSE
				CREATE_PICKUP shotgspa PICKUP_ONCE box2x box2y box2z gungun2
				REMOVE_BLIP gun_blip2 
				ADD_BLIP_FOR_PICKUP gungun2 gun_blip2 
				MARK_OBJECT_AS_NO_LONGER_NEEDED box2 
				create_gun2 = 1
				weapon_dropped ++
			ENDIF
		ENDIF
	ENDIF

	IF gun3_collected = 0
		IF create_gun3 = 0
			IF NOT HAS_OBJECT_BEEN_DAMAGED box3 
				GET_OBJECT_COORDINATES box3 box3x box3y box3z
				GET_GROUND_Z_FOR_3D_COORD box3x box3y box3z groundz_box
				IF groundz_box > 9.0
					groundz_box += 1.0
					box3z = groundz_box
				ENDIF	
			ELSE
				CREATE_PICKUP M60 PICKUP_ONCE box3x box3y box3z gungun3
				REMOVE_BLIP gun_blip3 
				ADD_BLIP_FOR_PICKUP gungun3 gun_blip3 
				MARK_OBJECT_AS_NO_LONGER_NEEDED box3 
				create_gun3 = 1
				weapon_dropped ++
			ENDIF
		ENDIF
	ENDIF

	IF gun4_collected = 0
		IF create_gun4 = 0
			IF NOT HAS_OBJECT_BEEN_DAMAGED box4 
				GET_OBJECT_COORDINATES box4 box4x box4y box4z
				GET_GROUND_Z_FOR_3D_COORD box4x box4y box4z groundz_box
				IF groundz_box > 9.0
					groundz_box += 1.0
					box4z = groundz_box
				ENDIF	
			ELSE
				CREATE_PICKUP ingramsl PICKUP_ONCE box4x box4y box4z gungun4
				REMOVE_BLIP gun_blip4 
				ADD_BLIP_FOR_PICKUP gungun4 gun_blip4 
				MARK_OBJECT_AS_NO_LONGER_NEEDED box4 
				create_gun4 = 1
				weapon_dropped ++
			ENDIF
		ENDIF
	ENDIF


//picking up the gun ON FOOT
	IF weapon_dropped > 0
		IF create_gun1 = 1
		OR create_gun2 = 1
		OR create_gun3 = 1
		OR create_gun4 = 1
			GOSUB gun_collected
		ENDIF
	ENDIF

//playing mission audio
IF NOT create_gun1 = 2
	IF phil_speech1 = 0
		//PRINT_NOW PHI1_06 5000 1//What you doing, driving like that?
		PLAY_MISSION_AUDIO 1
		//WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		//AND NOT IS_CHAR_DEAD mexican_driver  
		//	WAIT 0
		//ENDWHILE
		//CLEAR_MISSION_AUDIO 1
		//CLEAR_THIS_PRINT PHI1_06
		phil_speech1 = 1
	ENDIF
ENDIF

IF NOT create_gun3 = 2
	IF phil_speech3 = 0
		//PRINT_NOW PHI1_07 5000 1//Hey.
		PLAY_MISSION_AUDIO 2
		//WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
		//AND NOT IS_CHAR_DEAD mexican_driver3  
		//	WAIT 0
		//ENDWHILE
		//CLEAR_MISSION_AUDIO 2
		//CLEAR_THIS_PRINT PHI1_07
		phil_speech3 = 1
	ENDIF
ENDIF

//removing cars blips if the player1 is in them
	IF weapon_dropped = 0
		IF NOT IS_CAR_DEAD mexican_car 
			IF IS_PLAYER_IN_CAR player1 mexican_car
				REMOVE_BLIP mexican_car_blip
			ELSE
				IF gun1_collected = 0
					IF no_car_blip1 = 0
						REMOVE_BLIP mexican_car_blip
						ADD_BLIP_FOR_CAR mexican_car mexican_car_blip
						no_car_blip1 = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CAR_DEAD mexican_car2 
			IF IS_PLAYER_IN_CAR player1 mexican_car2
				REMOVE_BLIP mexican_car2_blip
			ELSE
				IF gun2_collected = 0
					IF no_car_blip2 = 0
						REMOVE_BLIP mexican_car2_blip
						ADD_BLIP_FOR_CAR mexican_car2 mexican_car2_blip
						no_car_blip2 = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CAR_DEAD mexican_car3 
			IF IS_PLAYER_IN_CAR player1 mexican_car3
				REMOVE_BLIP mexican_car3_blip
			ELSE
				IF gun3_collected = 0
					IF no_car_blip3 = 0
						REMOVE_BLIP mexican_car3_blip
						ADD_BLIP_FOR_CAR mexican_car3 mexican_car3_blip
						no_car_blip3 = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CAR_DEAD mexican_car4 
			IF IS_PLAYER_IN_CAR player1 mexican_car4
				REMOVE_BLIP mexican_car4_blip
			ELSE
				IF gun4_collected = 0
					IF no_car_blip4 = 0
						REMOVE_BLIP mexican_car4_blip
						ADD_BLIP_FOR_CAR mexican_car4 mexican_car4_blip
						no_car_blip4 = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


//setting where cars are going, the speed they go at and sorting them if they get stuck
IF NOT IS_CAR_DEAD mexican_car
	IF NOT IS_CHAR_DEAD mexican_driver 
		IF IS_CHAR_IN_CAR mexican_driver mexican_car 
			weapon_knocked_from_back_of_truck_var = weapon_knocked_from_back_of_truck1 
			set_mission_truck_var = set_mission_truck1
			mexican_car_var = mexican_car
			mexican_driver_var = mexican_driver 
			GOSUB setting_cars_up
			set_mission_truck1 = set_mission_truck_var
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_driver player1
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD mexican_car2
	IF NOT IS_CHAR_DEAD mexican_driver2 
		IF IS_CHAR_IN_CAR mexican_driver2 mexican_car2 
			weapon_knocked_from_back_of_truck_var = weapon_knocked_from_back_of_truck2 
			set_mission_truck_var = set_mission_truck2
			mexican_car_var = mexican_car2
			mexican_driver_var = mexican_driver2 
			GOSUB setting_cars_up
			set_mission_truck2 = set_mission_truck_var
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_driver2 player1
	    ENDIF
	ENDIF
ENDIF 

IF NOT IS_CAR_DEAD mexican_car3
	IF NOT IS_CHAR_DEAD mexican_driver3 
		IF IS_CHAR_IN_CAR mexican_driver3 mexican_car3 
			weapon_knocked_from_back_of_truck_var = weapon_knocked_from_back_of_truck3 
			set_mission_truck_var = set_mission_truck3
			mexican_car_var = mexican_car3
			mexican_driver_var = mexican_driver3 
			GOSUB setting_cars_up
			set_mission_truck3 = set_mission_truck_var
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_driver3 player1
		ENDIF
	ENDIF
ENDIF 

IF NOT IS_CAR_DEAD mexican_car4
	IF NOT IS_CHAR_DEAD mexican_driver4 
		IF IS_CHAR_IN_CAR mexican_driver4 mexican_car4 
			weapon_knocked_from_back_of_truck_var = weapon_knocked_from_back_of_truck4 
			set_mission_truck_var = set_mission_truck4
			mexican_car_var = mexican_car4
			mexican_driver_var = mexican_driver4 
			GOSUB setting_cars_up	
			set_mission_truck4 = set_mission_truck_var
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_driver4 player1
		ENDIF	
	ENDIF		   
ENDIF 


//setting attackers after player1 to slow him down
IF player1_got_all_guns = 2
	IF attackers_coming_to_get_ya = 0 
		PRINT ( PHI1_03 ) 7000 1 //Looks like they have called for back up
		attackers_coming_to_get_ya = 1
	ENDIF
ENDIF

IF attackers_coming_to_get_ya = 1
	IF all_attackers_alive = 4

//1st attacker
		IF NOT IS_CHAR_DEAD press_driver1 
			IF NOT IS_CAR_DEAD press_moped1
				IF IS_CHAR_IN_CAR press_driver1 press_moped1
					IF press_driver1_off_moped = 1
						SET_CAR_MISSION press_moped1 MISSION_BLOCKPLAYER_CLOSE 
						SET_CAR_DRIVING_STYLE press_moped1 DRIVINGMODE_AVOIDCARS 
						press_driver1_off_moped = 0
					ENDIF
					IF IS_PLAYER_IN_ANY_CAR player1 	
						GET_PLAYER_COORDINATES player1 player_x player_y player_z 
						IF LOCATE_CAR_2D press_moped1 player_x player_y 12.0 12.0 FALSE 
							SET_CAR_CRUISE_SPEED press_moped1 0.0 
							SET_CHAR_OBJ_LEAVE_CAR press_driver1 press_moped1
						ELSE
							IF LOCATE_CAR_2D press_moped1 player_x player_y 14.0 14.0 FALSE 
								SET_CAR_CRUISE_SPEED press_moped1 1.0
							ELSE
								IF LOCATE_CAR_2D press_moped1 player_x player_y 15.0 15.0 FALSE 
									SET_CAR_CRUISE_SPEED press_moped1 2.0
								ELSE	
									IF LOCATE_CAR_2D press_moped1 player_x player_y 18.0 18.0 FALSE 
										SET_CAR_CRUISE_SPEED press_moped1 3.0
									ELSE
										IF LOCATE_CAR_2D press_moped1 player_x player_y 20.0 20.0 FALSE 
											SET_CAR_CRUISE_SPEED press_moped1 4.0
										ELSE  
											SET_CAR_CRUISE_SPEED press_moped1 40.0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver1 13.0 13.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT press_driver1 player1
						ELSE
							SET_CAR_CRUISE_SPEED press_moped1 40.0
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD press_moped1
						IF LOCATE_CAR_3D press_moped1 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 5.0 5.0 5.0 0
							IF TIMERA > 4000
								IF NOT IS_CAR_ON_SCREEN press_moped1
									GET_CAR_COORDINATES press_moped1 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z
									GET_CLOSEST_CAR_NODE_WITH_HEADING mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z moped_heading
									IF NOT IS_POINT_ON_SCREEN mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0
										IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0 3.0 2.0
											SET_CAR_COORDINATES press_moped1 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 
											SET_CAR_HEADING press_moped1 moped_heading
						   					TIMERA = 0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
						IF NOT LOCATE_CAR_3D press_moped1 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 4.0 4.0 4.0 0
							GET_CAR_COORDINATES press_moped1 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z
							TIMERA = 0
						ENDIF
					ENDIF
				ELSE
					MARK_CAR_AS_NO_LONGER_NEEDED press_moped1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver1 13.0 13.0 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT press_driver1 player1
					ELSE
						press_driver1_off_moped = 1
						GOSUB steal_a_moped_1
					ENDIF
				ENDIF
			ELSE
				MARK_CAR_AS_NO_LONGER_NEEDED press_moped1
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver1 13.0 13.0 0
					press_driver1_off_moped = 1
					GOSUB steal_a_moped_1
				ENDIF
			ENDIF
		ELSE
			all_attackers_alive --
			IF NOT IS_GERMAN_GAME
				IF killing_bonus < 13 
					IF first_time_trigger = 1
						PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
						ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
						ADD_SCORE player1 100
						killing_bonus ++
					ENDIF
				ENDIF
			ENDIF
			MARK_CHAR_AS_NO_LONGER_NEEDED press_driver1
			MARK_CAR_AS_NO_LONGER_NEEDED press_moped1  
			flag_press1_moped_dead = 1
		ENDIF

//second attacker
		IF NOT IS_CHAR_DEAD press_driver2 
			IF NOT IS_CAR_DEAD press_moped2
				IF IS_CHAR_IN_CAR press_driver2 press_moped2
					IF press_driver2_off_moped = 1
						SET_CAR_MISSION press_moped2 MISSION_BLOCKPLAYER_CLOSE 
						SET_CAR_DRIVING_STYLE press_moped2 DRIVINGMODE_AVOIDCARS 
						press_driver2_off_moped = 0
					ENDIF
					IF IS_PLAYER_IN_ANY_CAR player1 	
						GET_PLAYER_COORDINATES player1 player_x player_y player_z 
						IF LOCATE_CAR_2D press_moped2 player_x player_y 12.0 12.0 FALSE 
							SET_CAR_CRUISE_SPEED press_moped2 0.0 
							SET_CHAR_OBJ_LEAVE_CAR press_driver2 press_moped2
						ELSE
							IF LOCATE_CAR_2D press_moped2 player_x player_y 14.0 14.0 FALSE 
								SET_CAR_CRUISE_SPEED press_moped2 1.0
							ELSE
								IF LOCATE_CAR_2D press_moped2 player_x player_y 15.0 15.0 FALSE 
									SET_CAR_CRUISE_SPEED press_moped2 2.0
								ELSE	
									IF LOCATE_CAR_2D press_moped2 player_x player_y 18.0 18.0 FALSE 
										SET_CAR_CRUISE_SPEED press_moped2 3.0
									ELSE
										IF LOCATE_CAR_2D press_moped2 player_x player_y 20.0 20.0 FALSE 
											SET_CAR_CRUISE_SPEED press_moped2 4.0
										ELSE  
											SET_CAR_CRUISE_SPEED press_moped2 40.0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver2 13.0 13.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT press_driver2 player1
						ELSE
							SET_CAR_CRUISE_SPEED press_moped2 40.0
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD press_moped2
						IF LOCATE_CAR_3D press_moped2 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 5.0 5.0 5.0 0
							IF TIMERA > 4000
								IF NOT IS_CAR_ON_SCREEN press_moped2
									GET_CAR_COORDINATES press_moped2 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z
									GET_CLOSEST_CAR_NODE_WITH_HEADING mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z moped_heading
									IF NOT IS_POINT_ON_SCREEN mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0
										IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0 3.0 2.0
											SET_CAR_COORDINATES press_moped2 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 
											SET_CAR_HEADING press_moped2 moped_heading
						   					TIMERA = 0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
						IF NOT LOCATE_CAR_3D press_moped2 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 4.0 4.0 4.0 0
							GET_CAR_COORDINATES press_moped2 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z
							TIMERA = 0
						ENDIF
					ENDIF
				ELSE
					MARK_CAR_AS_NO_LONGER_NEEDED press_moped2
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver2 13.0 13.0 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT press_driver2 player1
					ELSE
						press_driver2_off_moped = 1
						GOSUB steal_a_moped_2
					ENDIF
				ENDIF
			ELSE 
				MARK_CAR_AS_NO_LONGER_NEEDED press_moped2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver2 13.0 13.0 0
					press_driver2_off_moped = 1
					GOSUB steal_a_moped_2
				ENDIF
			ENDIF
		ELSE
			all_attackers_alive --
			IF NOT IS_GERMAN_GAME
				IF killing_bonus < 13 
					IF first_time_trigger = 1
						PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
						ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
						ADD_SCORE player1 100
						killing_bonus ++
					ENDIF
				ENDIF
			ENDIF
			MARK_CHAR_AS_NO_LONGER_NEEDED press_driver2
			MARK_CAR_AS_NO_LONGER_NEEDED press_moped2  
			flag_press2_moped_dead = 1
		ENDIF

//third attacker
		IF NOT IS_CHAR_DEAD press_driver3 
			IF NOT IS_CAR_DEAD press_moped3
				IF IS_CHAR_IN_CAR press_driver3 press_moped3
					IF press_driver3_off_moped = 1
						SET_CAR_MISSION press_moped3 MISSION_BLOCKPLAYER_CLOSE 
						SET_CAR_DRIVING_STYLE press_moped3 DRIVINGMODE_AVOIDCARS 
						press_driver3_off_moped = 0
					ENDIF
					IF IS_PLAYER_IN_ANY_CAR player1 	
						GET_PLAYER_COORDINATES player1 player_x player_y player_z 
						IF LOCATE_CAR_2D press_moped3 player_x player_y 12.0 12.0 FALSE 
							SET_CAR_CRUISE_SPEED press_moped3 0.0 
							SET_CHAR_OBJ_LEAVE_CAR press_driver3 press_moped3
						ELSE
							IF LOCATE_CAR_2D press_moped3 player_x player_y 14.0 14.0 FALSE 
								SET_CAR_CRUISE_SPEED press_moped3 1.0
							ELSE
								IF LOCATE_CAR_2D press_moped3 player_x player_y 15.0 15.0 FALSE 
									SET_CAR_CRUISE_SPEED press_moped3 2.0
								ELSE	
									IF LOCATE_CAR_2D press_moped3 player_x player_y 18.0 18.0 FALSE 
										SET_CAR_CRUISE_SPEED press_moped3 3.0
									ELSE
										IF LOCATE_CAR_2D press_moped3 player_x player_y 20.0 20.0 FALSE 
											SET_CAR_CRUISE_SPEED press_moped3 4.0
										ELSE  
											SET_CAR_CRUISE_SPEED press_moped3 40.0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver3 13.0 13.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT press_driver3 player1
						ELSE
							SET_CAR_CRUISE_SPEED press_moped3 40.0
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD press_moped3
						IF LOCATE_CAR_3D press_moped3 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 5.0 5.0 5.0 0
							IF TIMERA > 4000
								IF NOT IS_CAR_ON_SCREEN press_moped3
									GET_CAR_COORDINATES press_moped3 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z
									GET_CLOSEST_CAR_NODE_WITH_HEADING mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z moped_heading
									IF NOT IS_POINT_ON_SCREEN mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0
										IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0 3.0 2.0
											SET_CAR_COORDINATES press_moped3 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 
											SET_CAR_HEADING press_moped3 moped_heading
						   					TIMERA = 0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
						IF NOT LOCATE_CAR_3D press_moped3 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 4.0 4.0 4.0 0
							GET_CAR_COORDINATES press_moped3 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z
							TIMERA = 0
						ENDIF
					ENDIF
				ELSE
					MARK_CAR_AS_NO_LONGER_NEEDED press_moped3
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver3 13.0 13.0 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT press_driver3 player1
					ELSE
						press_driver3_off_moped = 1
						GOSUB steal_a_moped_3
					ENDIF
				ENDIF
			ELSE 
				MARK_CAR_AS_NO_LONGER_NEEDED press_moped3
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver3 13.0 13.0 0
					press_driver3_off_moped = 1
					GOSUB steal_a_moped_3
				ENDIF	
			ENDIF
		ELSE
			all_attackers_alive --
			IF NOT IS_GERMAN_GAME
				IF killing_bonus < 13 
					IF first_time_trigger = 1
						PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
						ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
						ADD_SCORE player1 100
						killing_bonus ++
					ENDIF
				ENDIF
			ENDIF
			MARK_CHAR_AS_NO_LONGER_NEEDED press_driver3
			MARK_CAR_AS_NO_LONGER_NEEDED press_moped3  
			flag_press3_moped_dead = 1
		ENDIF

//fourth attacker
		IF NOT IS_CHAR_DEAD press_driver4 
			IF NOT IS_CAR_DEAD press_moped4
				IF IS_CHAR_IN_CAR press_driver4 press_moped4
					IF press_driver4_off_moped = 1
						SET_CAR_MISSION press_moped4 MISSION_BLOCKPLAYER_CLOSE 
						SET_CAR_DRIVING_STYLE press_moped4 DRIVINGMODE_AVOIDCARS 
						press_driver4_off_moped = 0
					ENDIF
					IF IS_PLAYER_IN_ANY_CAR player1 	
						GET_PLAYER_COORDINATES player1 player_x player_y player_z 
						IF LOCATE_CAR_2D press_moped4 player_x player_y 12.0 12.0 FALSE 
							SET_CAR_CRUISE_SPEED press_moped4 0.0 
							SET_CHAR_OBJ_LEAVE_CAR press_driver4 press_moped4
						ELSE
							IF LOCATE_CAR_2D press_moped4 player_x player_y 14.0 14.0 FALSE 
								SET_CAR_CRUISE_SPEED press_moped4 1.0
							ELSE
								IF LOCATE_CAR_2D press_moped4 player_x player_y 15.0 15.0 FALSE 
									SET_CAR_CRUISE_SPEED press_moped4 2.0
								ELSE	
									IF LOCATE_CAR_2D press_moped4 player_x player_y 18.0 18.0 FALSE 
										SET_CAR_CRUISE_SPEED press_moped4 3.0
									ELSE
										IF LOCATE_CAR_2D press_moped4 player_x player_y 20.0 20.0 FALSE 
											SET_CAR_CRUISE_SPEED press_moped4 4.0
										ELSE  
											SET_CAR_CRUISE_SPEED press_moped4 40.0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver4 13.0 13.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT press_driver4 player1
						ELSE
							SET_CAR_CRUISE_SPEED press_moped4 40.0
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD press_moped4
						IF LOCATE_CAR_3D press_moped4 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 5.0 5.0 5.0 0
							IF TIMERA > 4000
								IF NOT IS_CAR_ON_SCREEN press_moped4
									GET_CAR_COORDINATES press_moped4 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z
									GET_CLOSEST_CAR_NODE_WITH_HEADING mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z moped_heading
									IF NOT IS_POINT_ON_SCREEN mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0
										IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0 3.0 2.0
											SET_CAR_COORDINATES press_moped4 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 
											SET_CAR_HEADING press_moped4 moped_heading
						   					TIMERA = 0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
						IF NOT LOCATE_CAR_3D press_moped4 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 4.0 4.0 4.0 0
							GET_CAR_COORDINATES press_moped4 mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z
							TIMERA = 0
						ENDIF
					ENDIF
				ELSE
					MARK_CAR_AS_NO_LONGER_NEEDED press_moped4
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver4 13.0 13.0 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT press_driver4 player1
					ELSE
						press_driver4_off_moped = 1
						GOSUB steal_a_moped_4
					ENDIF
				ENDIF
			ELSE
				MARK_CAR_AS_NO_LONGER_NEEDED press_moped4
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver4 13.0 13.0 0
					press_driver4_off_moped = 1 
					GOSUB steal_a_moped_4
				ENDIF
			ENDIF
		ELSE
			all_attackers_alive --
			IF NOT IS_GERMAN_GAME
				IF killing_bonus < 10 
					IF first_time_trigger = 1
						PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
						ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
						ADD_SCORE player1 100
						killing_bonus ++
					ENDIF
				ENDIF
			ENDIF
			MARK_CHAR_AS_NO_LONGER_NEEDED press_driver4
			MARK_CAR_AS_NO_LONGER_NEEDED press_moped4  
			flag_press4_moped_dead = 1
		ENDIF

	ELSE
		GOSUB make_cars
	ENDIF
ENDIF


//deleting blips if cars are dead and removing vehicles and ped models from pool
IF IS_CAR_DEAD mexican_car
	IF NOT IS_CHAR_DEAD mexican_gunner 
		DETACH_CHAR_FROM_CAR mexican_gunner
		EXPLODE_CHAR_HEAD mexican_gunner  
	ENDIF
	REMOVE_BLIP mexican_car_blip
	MARK_CAR_AS_NO_LONGER_NEEDED mexican_car 
ENDIF
IF IS_CAR_DEAD mexican_car2
	REMOVE_BLIP mexican_car2_blip
	MARK_CAR_AS_NO_LONGER_NEEDED mexican_car2 
ENDIF
IF IS_CAR_DEAD mexican_car3
	IF NOT IS_CHAR_DEAD mexican_gunner1 
		DETACH_CHAR_FROM_CAR mexican_gunner1 
		EXPLODE_CHAR_HEAD mexican_gunner1  
	ENDIF
	REMOVE_BLIP mexican_car3_blip
	MARK_CAR_AS_NO_LONGER_NEEDED mexican_car3 
ENDIF
IF IS_CAR_DEAD mexican_car4
	REMOVE_BLIP mexican_car4_blip
	MARK_CAR_AS_NO_LONGER_NEEDED mexican_car4 
ENDIF


IF NOT IS_CHAR_DEAD mexican_gunner
	IF IS_PLAYER_IN_CAR player1 mexican_car
		DETACH_CHAR_FROM_CAR mexican_gunner
		IF gunner_attack = 0
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_gunner player1 
			gunner_attack = 1
		ENDIF
	ENDIF
ENDIF  
IF NOT IS_CHAR_DEAD mexican_gunner1
	IF IS_PLAYER_IN_CAR player1 mexican_car3
		DETACH_CHAR_FROM_CAR mexican_gunner1
		IF gunner1_attack = 0
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_gunner1 player1 
			gunner1_attack = 1
		ENDIF
	ENDIF
ENDIF  

IF IS_CHAR_DEAD mexican_gunner 
	DETACH_CHAR_FROM_CAR mexican_gunner
	MARK_CHAR_AS_NO_LONGER_NEEDED mexican_gunner   
ENDIF
IF IS_CHAR_DEAD mexican_gunner1 
	DETACH_CHAR_FROM_CAR mexican_gunner1
	MARK_CHAR_AS_NO_LONGER_NEEDED mexican_gunner1   
ENDIF
IF IS_CHAR_DEAD mexican_driver
	MARK_CHAR_AS_NO_LONGER_NEEDED mexican_driver
ENDIF 
IF IS_CHAR_DEAD mexican_driver2
	MARK_CHAR_AS_NO_LONGER_NEEDED mexican_driver2
ENDIF 
IF IS_CHAR_DEAD mexican_driver3
	MARK_CHAR_AS_NO_LONGER_NEEDED mexican_driver3
ENDIF 
IF IS_CHAR_DEAD mexican_driver4
	MARK_CHAR_AS_NO_LONGER_NEEDED mexican_driver4
ENDIF 
IF IS_CHAR_DEAD mexican_gunner
	MARK_CHAR_AS_NO_LONGER_NEEDED mexican_gunner
ENDIF 
IF IS_CHAR_DEAD mexican_gunner1
	MARK_CHAR_AS_NO_LONGER_NEEDED mexican_gunner1
ENDIF 

//instructing player1 to destroy cars after all guns are dropped
IF gun_runner_goals = 1
	IF IS_CAR_DEAD mexican_car
		IF IS_CAR_DEAD mexican_car2
			IF IS_CAR_DEAD mexican_car3
				IF IS_CAR_DEAD mexican_car4
					GOTO mission_phil1_passed
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD mexican_car
	IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mexican_car 200.0 200.0 FALSE
		FREEZE_CAR_POSITION_AND_DONT_LOAD_COLLISION mexican_car TRUE
	ELSE
		FREEZE_CAR_POSITION_AND_DONT_LOAD_COLLISION mexican_car FALSE
	ENDIF
ELSE
	IF driving_like_nutters_flag = 0
		driving_like_nutters_flag = 1
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD mexican_car2
	IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mexican_car2 200.0 200.0 FALSE
		FREEZE_CAR_POSITION_AND_DONT_LOAD_COLLISION mexican_car2 TRUE
	ELSE
		FREEZE_CAR_POSITION_AND_DONT_LOAD_COLLISION mexican_car2 FALSE
	ENDIF
ELSE
	IF driving_like_nutters_flag = 0
		driving_like_nutters_flag = 1
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD mexican_car3
	IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mexican_car3 200.0 200.0 FALSE
		FREEZE_CAR_POSITION_AND_DONT_LOAD_COLLISION mexican_car3 TRUE
	ELSE
		FREEZE_CAR_POSITION_AND_DONT_LOAD_COLLISION mexican_car3 FALSE
	ENDIF
ELSE
	IF driving_like_nutters_flag = 0
		driving_like_nutters_flag = 1
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD mexican_car4
	IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mexican_car4 200.0 200.0 FALSE
		FREEZE_CAR_POSITION_AND_DONT_LOAD_COLLISION mexican_car4 TRUE
	ELSE
		FREEZE_CAR_POSITION_AND_DONT_LOAD_COLLISION mexican_car4 FALSE
	ENDIF
ELSE
	IF driving_like_nutters_flag = 0
		driving_like_nutters_flag = 1
	ENDIF
ENDIF


	   

GOTO gun_runner_loop///////////////////////////////////////////////////////////////////////////////////////


// Mission failed
mission_failed_phil1:

PRINT_BIG ( m_fail ) 5000 1
RETURN

   

// mission passed
mission_phil1_passed:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG M_PASS 2000 5000 1
ADD_SCORE player1 2000
CLEAR_WANTED_LEVEL player1
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
REGISTER_MISSION_PASSED PHIL_1
REMOVE_BLIP phil_contact_blip
flag_phil_mission1_passed = 1
RETURN



// mission cleanup
mission_cleanup_phil1:

IF NOT HAS_PICKUP_BEEN_COLLECTED grenades_pickup 
	REMOVE_PICKUP grenades_pickup
ENDIF
REMOVE_BLIP mexican_car_blip
REMOVE_BLIP mexican_car2_blip
REMOVE_BLIP mexican_car3_blip
REMOVE_BLIP mexican_car4_blip
REMOVE_BLIP	gun_blip1
REMOVE_BLIP	gun_blip2
REMOVE_BLIP	gun_blip3
REMOVE_BLIP	gun_blip4
DELETE_OBJECT box1
DELETE_OBJECT box2
DELETE_OBJECT box3
DELETE_OBJECT box4
MARK_MODEL_AS_NO_LONGER_NEEDED walton
MARK_MODEL_AS_NO_LONGER_NEEDED WMYCR
MARK_MODEL_AS_NO_LONGER_NEEDED faggio
MARK_MODEL_AS_NO_LONGER_NEEDED python
MARK_MODEL_AS_NO_LONGER_NEEDED shotgspa
MARK_MODEL_AS_NO_LONGER_NEEDED ingramsl
MARK_MODEL_AS_NO_LONGER_NEEDED M60
MARK_MODEL_AS_NO_LONGER_NEEDED gunbox
MARK_MODEL_AS_NO_LONGER_NEEDED patriot
MARK_MODEL_AS_NO_LONGER_NEEDED uzi
REMOVE_PICKUP gungun1 
REMOVE_PICKUP gungun2 
REMOVE_PICKUP gungun3 
REMOVE_PICKUP gungun4 
flag_player_on_mission = 0
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN


///////////////////////////////////////////////////////////////////////////////////
gun_collected://///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
IF gun1_collected = 0 
	IF create_gun1 = 1
		IF HAS_PICKUP_BEEN_COLLECTED gungun1
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			REMOVE_BLIP gun_blip1
			player1_got_all_guns ++
			weapon_dropped --
			gun1_collected = 1
			create_gun1 = 0
			IF weapon_dropped = 0
				no_car_blip1 = 0
				no_car_blip2 = 0
				no_car_blip3 = 0
				no_car_blip4 = 0
			ENDIF
			RETURN
		ENDIF
	ENDIF
ENDIF

IF gun2_collected = 0 
	IF create_gun2 = 1
		IF HAS_PICKUP_BEEN_COLLECTED gungun2 
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			REMOVE_BLIP gun_blip2
			player1_got_all_guns ++
			weapon_dropped --
			gun2_collected = 1
			create_gun2 = 0
			IF weapon_dropped = 0
				no_car_blip1 = 0
				no_car_blip2 = 0
				no_car_blip3 = 0
				no_car_blip4 = 0
			ENDIF
			RETURN
		ENDIF
	ENDIF
ENDIF

IF gun3_collected = 0 
	IF create_gun3 = 1
		IF HAS_PICKUP_BEEN_COLLECTED gungun3 
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			REMOVE_BLIP gun_blip3
			player1_got_all_guns ++
			weapon_dropped --
			gun3_collected = 1
			create_gun3 = 0
			IF weapon_dropped = 0
				no_car_blip1 = 0
				no_car_blip2 = 0
				no_car_blip3 = 0
				no_car_blip4 = 0
			ENDIF
			RETURN

		ENDIF
	ENDIF
ENDIF

IF gun4_collected = 0 
	IF create_gun4 = 1
		IF HAS_PICKUP_BEEN_COLLECTED gungun4 
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			REMOVE_BLIP gun_blip4
			player1_got_all_guns ++
			weapon_dropped --
			gun4_collected = 1
			create_gun4 = 0
			IF weapon_dropped = 0
				no_car_blip1 = 0
				no_car_blip2 = 0
				no_car_blip3 = 0
				no_car_blip4 = 0
			ENDIF
			RETURN

		ENDIF
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
setting_cars_up:///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
//car speed
IF driving_like_nutters_flag = 1 
	GET_CAR_COORDINATES mexican_car_var mexican_car_x mexican_car_y mexican_car_z
	GET_PLAYER_COORDINATES player1 player_x player_y player_z 
	x_tem = player_x - mexican_car_x 
	y_tem = player_y - mexican_car_y
	x_tem = x_tem * x_tem
	y_tem = y_tem * y_tem
	sum_x_y_tem = x_tem + y_tem
	SQRT sum_x_y_tem sum_x_y_tem

	mexican_car_speed = 640.0 / sum_x_y_tem

	IF mexican_car_speed > 20.0
		mexican_car_speed = 20.0
	ENDIF
	IF attackers_coming_to_get_ya = 1 	
		IF mexican_car_speed < 20.0
			mexican_car_speed = 20.0
		ENDIF
	ELSE
		IF mexican_car_speed < 10.0
			mexican_car_speed = 10.0
		ENDIF
	ENDIF
	SET_CAR_CRUISE_SPEED mexican_car_var mexican_car_speed
ENDIF

//driving style and either telling cars to ram player1 or telling cars to run away from player1

IF weapon_knocked_from_back_of_truck_var = 1
	IF NOT IS_CHAR_DEAD mexican_driver_var 
		IF IS_CHAR_IN_CAR mexican_driver_var mexican_car_var

			IF set_mission_truck_var = 0
				SET_CAR_MISSION mexican_car_var MISSION_RAMPLAYER_CLOSE
				set_mission_truck_var = 1
			ENDIF
				 
			IF driving_like_nutters_flag = 0
				IF NOT IS_CAR_DEAD mexican_car 
					SET_CAR_DRIVING_STYLE mexican_car 2
				ENDIF
				IF NOT IS_CAR_DEAD mexican_car2 
					SET_CAR_DRIVING_STYLE mexican_car2 2
				ENDIF
				IF NOT IS_CAR_DEAD mexican_car3 
					SET_CAR_DRIVING_STYLE mexican_car3 2
				ENDIF
				IF NOT IS_CAR_DEAD mexican_car4 
					SET_CAR_DRIVING_STYLE mexican_car4 2
				ENDIF
				driving_like_nutters_flag = 1
			ENDIF
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_driver_var player1 
		ENDIF
	ENDIF
ENDIF

IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mexican_car_var 80.0 80.0 FALSE  
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mexican_car_var TRUE
ELSE
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mexican_car_var FALSE
ENDIF

//car stuck

IF NOT IS_CHAR_DEAD mexican_driver_var 
	IF IS_CHAR_IN_CAR mexican_driver_var mexican_car_var 
		IF NOT IS_CAR_DEAD mexican_car_var
			IF LOCATE_CAR_3D mexican_car_var mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 5.0 5.0 5.0 0
				IF TIMERA > 4000
					IF NOT IS_CAR_ON_SCREEN mexican_car_var
						GET_CAR_COORDINATES mexican_car_var mexican_car_x mexican_car_y mexican_car_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING mexican_car_x mexican_car_y mexican_car_z mexican_car_x mexican_car_y mexican_car_z mex_warp_heading
						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mexican_car_x mexican_car_y mexican_car_z 5.0 5.0 5.0
							IF NOT IS_POINT_ON_SCREEN mexican_car_x mexican_car_y mexican_car_z 4.0
								SET_CAR_COORDINATES mexican_car_var mexican_car_x mexican_car_y mexican_car_z 
								SET_CAR_HEADING mexican_car_var mex_warp_heading
			   					TIMERA = 0
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF NOT LOCATE_CAR_3D mexican_car_var mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z 4.0 4.0 4.0 0
				GET_CAR_COORDINATES mexican_car_var mexican_car_stuck_x mexican_car_stuck_y mexican_car_stuck_z
				TIMERA = 0
			ENDIF
		ENDIF
	ELSE
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_driver_var player1 
	ENDIF
ENDIF

//car in water
	
IF NOT IS_CHAR_DEAD mexican_driver_var 
	IF IS_CHAR_IN_CAR mexican_driver_var mexican_car_var 
		IF IS_CAR_DEAD mexican_car_var
			IF IS_CAR_IN_WATER mexican_car_var
				IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mexican_car_var 50.0 50.0 0
					IF NOT IS_CAR_ON_SCREEN mexican_car_var
						GET_CAR_COORDINATES mexican_car_var mexican_car_x mexican_car_y mexican_car_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING mexican_car_x mexican_car_y mexican_car_z mexican_car_x mexican_car_y mexican_car_z mex_warp_heading
						IF NOT IS_POINT_ON_SCREEN mexican_car_x mexican_car_y mexican_car_z 3.0
							SET_CAR_COORDINATES mexican_car_var mexican_car_x mexican_car_y mexican_car_z
							SET_CAR_HEADING	mexican_car_var mex_warp_heading
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_driver_var player1 
	ENDIF
ENDIF

//car upsidedown

IF NOT IS_CHAR_DEAD mexican_driver_var 
	IF IS_CHAR_IN_CAR mexican_driver_var mexican_car_var 
		IF IS_CAR_UPSIDEDOWN mexican_car_var
		AND IS_CAR_STOPPED mexican_car_var
			IF NOT IS_CAR_ON_SCREEN mexican_car_var
				SET_UPSIDEDOWN_CAR_NOT_DAMAGED mexican_car_var TRUE
				GET_CAR_COORDINATES mexican_car_var mexican_car_x mexican_car_y mexican_car_z
				GET_CLOSEST_CAR_NODE_WITH_HEADING mexican_car_x mexican_car_y mexican_car_z mexican_car_x mexican_car_y mexican_car_z mex_warp_heading
				IF NOT IS_POINT_ON_SCREEN mexican_car_x mexican_car_y mexican_car_z 3.0
					SET_CAR_COORDINATES mexican_car_var mexican_car_x mexican_car_y mexican_car_z
					SET_CAR_HEADING	mexican_car_var mex_warp_heading
					SET_UPSIDEDOWN_CAR_NOT_DAMAGED mexican_car_var FALSE
				ENDIF
			ENDIF
		ENDIF
	ELSE
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mexican_driver_var player1 
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
make_cars://///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
IF flag_press1_moped_dead = 1
	MARK_CAR_AS_NO_LONGER_NEEDED press_moped1 
	MARK_CHAR_AS_NO_LONGER_NEEDED press_driver1 
	IF NOT IS_PLAYER_IN_ZONE player1 HAITI  
		CREATE_CAR faggio -984.7 -73.1 9.9 press_moped1  
	ELSE
		CREATE_CAR faggio -679.5 652.6 9.9 press_moped1
		SET_CAR_HEADING press_moped1 173.4  
	ENDIF
	
	CREATE_CHAR_INSIDE_CAR press_moped1 PEDTYPE_CIVMALE WMYCR press_driver1
    
    
	GIVE_WEAPON_TO_CHAR press_driver1 WEAPONTYPE_UZI 30000
	SET_CAR_ONLY_DAMAGED_BY_PLAYER press_moped1 TRUE
	SET_CAR_MISSION press_moped1 MISSION_BLOCKPLAYER_CLOSE 
	SET_CAR_DRIVING_STYLE press_moped1 DRIVINGMODE_AVOIDCARS 
	all_attackers_alive ++
	flag_press1_moped_dead = 0
ENDIF

IF flag_press2_moped_dead = 1 
	MARK_CAR_AS_NO_LONGER_NEEDED press_moped2 
	MARK_CHAR_AS_NO_LONGER_NEEDED press_driver2 
	IF NOT IS_PLAYER_IN_ZONE player1 HAITI  
		CREATE_CAR faggio -984.7 -78.1 9.9 press_moped2  
	ELSE
		CREATE_CAR faggio -679.5 657.6 9.9 press_moped2
		SET_CAR_HEADING press_moped2 173.4  
	ENDIF 
	
	CREATE_CHAR_INSIDE_CAR press_moped2 PEDTYPE_CIVMALE WMYCR press_driver2
   
	
	GIVE_WEAPON_TO_CHAR press_driver2 WEAPONTYPE_UZI 30000
	SET_CAR_ONLY_DAMAGED_BY_PLAYER press_moped2 TRUE
	SET_CAR_MISSION press_moped2 MISSION_BLOCKPLAYER_CLOSE 
	SET_CAR_DRIVING_STYLE press_moped2 DRIVINGMODE_AVOIDCARS 
	all_attackers_alive ++
	flag_press2_moped_dead = 0
ENDIF

IF flag_press3_moped_dead = 1 
	MARK_CAR_AS_NO_LONGER_NEEDED press_moped3 
	MARK_CHAR_AS_NO_LONGER_NEEDED press_driver3 
	IF NOT IS_PLAYER_IN_ZONE player1 HAITI  
		CREATE_CAR faggio -984.7 -83.1 9.9 press_moped3  
	ELSE
		CREATE_CAR faggio -679.5 662.6 9.9 press_moped3
		SET_CAR_HEADING press_moped3 173.4  
	ENDIF 
	
	CREATE_CHAR_INSIDE_CAR press_moped3 PEDTYPE_CIVMALE WMYCR press_driver3

    
	
	GIVE_WEAPON_TO_CHAR press_driver3 WEAPONTYPE_UZI 30000
	SET_CAR_ONLY_DAMAGED_BY_PLAYER press_moped3 TRUE
	SET_CAR_MISSION press_moped3 MISSION_BLOCKPLAYER_CLOSE 
	SET_CAR_DRIVING_STYLE press_moped3 DRIVINGMODE_AVOIDCARS 
	all_attackers_alive ++
	flag_press3_moped_dead = 0
ENDIF

IF flag_press4_moped_dead = 1 
	MARK_CAR_AS_NO_LONGER_NEEDED press_moped4 
	MARK_CHAR_AS_NO_LONGER_NEEDED press_driver4 
	IF NOT IS_PLAYER_IN_ZONE player1 HAITI  
		CREATE_CAR faggio -984.7 -88.1 9.9 press_moped4  
	ELSE
		CREATE_CAR faggio -679.5 667.6 9.9 press_moped4
		SET_CAR_HEADING press_moped4 173.4  
	ENDIF 
	
	CREATE_CHAR_INSIDE_CAR press_moped4 PEDTYPE_CIVMALE WMYCR press_driver4

    
	GIVE_WEAPON_TO_CHAR press_driver4 WEAPONTYPE_UZI 30000
	SET_CAR_ONLY_DAMAGED_BY_PLAYER press_moped4 TRUE
	SET_CAR_MISSION press_moped4 MISSION_BLOCKPLAYER_CLOSE 
	SET_CAR_DRIVING_STYLE press_moped4 DRIVINGMODE_AVOIDCARS 
	all_attackers_alive ++
	flag_press4_moped_dead = 0
ENDIF

IF first_time_trigger = 0
	first_time_trigger = 1
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
steal_a_moped_1:///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
//attacker 1
IF press_driver1_off_moped = 1 
	IF NOT IS_CHAR_DEAD press_driver1 
		GET_CHAR_COORDINATES press_driver1 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver1 50.0 50.0 0
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver1 13.0 13.0 0
				mopedcoord_2_x = mopedcoord_1_x + 20.0
				mopedcoord_2_y = mopedcoord_1_y + 20.0
				mopedcoord_1_x = mopedcoord_1_x - 20.0
				mopedcoord_1_y = mopedcoord_1_y - 20.0
				MARK_CAR_AS_NO_LONGER_NEEDED press_moped1 
				GET_RANDOM_CAR_OF_TYPE_IN_AREA mopedcoord_1_x mopedcoord_1_y mopedcoord_2_x mopedcoord_2_y -1 press_moped1
				IF NOT press_moped1 = -1
					LOCK_CAR_DOORS press_moped1 CARLOCK_UNLOCKED
					SET_CAR_CRUISE_SPEED press_moped1 0.0
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER press_driver1 press_moped1
					SET_CHAR_RUNNING press_driver1 TRUE
				ENDIF
			ENDIF
		ELSE
			GET_CLOSEST_CAR_NODE_WITH_HEADING mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z moped_heading
			IF NOT IS_POINT_ON_SCREEN mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0 3.0 2.0
					MARK_CAR_AS_NO_LONGER_NEEDED press_moped1
					CREATE_CAR faggio mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z press_moped1
					SET_CAR_HEADING	press_moped1 moped_heading
					IF NOT IS_CHAR_IN_ANY_CAR press_driver1 
						WARP_CHAR_INTO_CAR press_driver1 press_moped1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CAR_DEAD press_moped1
			IF NOT IS_CHAR_DEAD press_driver1 
				IF IS_CHAR_IN_CAR press_driver1 press_moped1 
					SET_CAR_MISSION press_moped1 MISSION_BLOCKPLAYER_CLOSE 
					SET_CAR_DRIVING_STYLE press_moped1 DRIVINGMODE_AVOIDCARS 
					press_driver1_off_moped = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
steal_a_moped_2:///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
//attacker 2
IF press_driver2_off_moped = 1 
	IF NOT IS_CHAR_DEAD press_driver2 
		GET_CHAR_COORDINATES press_driver2 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver2 50.0 50.0 0
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver2 13.0 13.0 0 		
				mopedcoord_2_x = mopedcoord_1_x + 20.0
				mopedcoord_2_y = mopedcoord_1_y + 20.0
				mopedcoord_1_x = mopedcoord_1_x - 20.0
				mopedcoord_1_y = mopedcoord_1_y - 20.0
				MARK_CAR_AS_NO_LONGER_NEEDED press_moped2 
				GET_RANDOM_CAR_OF_TYPE_IN_AREA mopedcoord_1_x mopedcoord_1_y mopedcoord_2_x mopedcoord_2_y -1 press_moped2
				IF NOT press_moped2 = -1
					LOCK_CAR_DOORS press_moped2 CARLOCK_UNLOCKED
					SET_CAR_CRUISE_SPEED press_moped2 0.0
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER press_driver2 press_moped2
					SET_CHAR_RUNNING press_driver2 TRUE
				ENDIF
			ENDIF
		ELSE
			GET_CLOSEST_CAR_NODE_WITH_HEADING mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z moped_heading
			IF NOT IS_POINT_ON_SCREEN mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0 3.0 2.0
					MARK_CAR_AS_NO_LONGER_NEEDED press_moped2
					CREATE_CAR faggio mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z press_moped2
					SET_CAR_HEADING	press_moped2 moped_heading
					IF NOT IS_CHAR_IN_ANY_CAR press_driver2 
						WARP_CHAR_INTO_CAR press_driver2 press_moped2
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CAR_DEAD press_moped2
			IF NOT IS_CHAR_DEAD press_driver2 
				IF IS_CHAR_IN_CAR press_driver2 press_moped2 
					SET_CAR_MISSION press_moped2 MISSION_BLOCKPLAYER_CLOSE 
					SET_CAR_DRIVING_STYLE press_moped2 DRIVINGMODE_AVOIDCARS 
					press_driver2_off_moped = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
steal_a_moped_3:///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
//attacker 3
IF press_driver3_off_moped = 1 
	IF NOT IS_CHAR_DEAD press_driver3 
		GET_CHAR_COORDINATES press_driver3 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver3 50.0 50.0 0
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver3 13.0 13.0 0 		
				mopedcoord_2_x = mopedcoord_1_x + 20.0
				mopedcoord_2_y = mopedcoord_1_y + 20.0
				mopedcoord_1_x = mopedcoord_1_x - 20.0
				mopedcoord_1_y = mopedcoord_1_y - 20.0
				MARK_CAR_AS_NO_LONGER_NEEDED press_moped3 
				GET_RANDOM_CAR_OF_TYPE_IN_AREA mopedcoord_1_x mopedcoord_1_y mopedcoord_2_x mopedcoord_2_y -1 press_moped3
				IF NOT press_moped3 = -1
					LOCK_CAR_DOORS press_moped3 CARLOCK_UNLOCKED
					SET_CAR_CRUISE_SPEED press_moped3 0.0
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER press_driver3 press_moped3
					SET_CHAR_RUNNING press_driver3 TRUE
				ENDIF
			ENDIF
		ELSE
			GET_CLOSEST_CAR_NODE_WITH_HEADING mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z moped_heading
			IF NOT IS_POINT_ON_SCREEN mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0 3.0 2.0
					MARK_CAR_AS_NO_LONGER_NEEDED press_moped3
					CREATE_CAR faggio mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z press_moped3
					SET_CAR_HEADING	press_moped3 moped_heading
					IF NOT IS_CHAR_IN_ANY_CAR press_driver3 
					    WARP_CHAR_INTO_CAR press_driver3 press_moped3
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CAR_DEAD press_moped3
			IF NOT IS_CHAR_DEAD press_driver3 
				IF IS_CHAR_IN_CAR press_driver3 press_moped3 
					SET_CAR_MISSION press_moped3 MISSION_BLOCKPLAYER_CLOSE 
					SET_CAR_DRIVING_STYLE press_moped3 DRIVINGMODE_AVOIDCARS 
					press_driver3_off_moped = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
steal_a_moped_4:///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
//attacker 4
IF press_driver4_off_moped = 1 
	IF NOT IS_CHAR_DEAD press_driver4 
		GET_CHAR_COORDINATES press_driver4 mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver4 50.0 50.0 0
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 press_driver4 13.0 13.0 0 		
				mopedcoord_2_x = mopedcoord_1_x + 20.0
				mopedcoord_2_y = mopedcoord_1_y + 20.0
				mopedcoord_1_x = mopedcoord_1_x - 20.0
				mopedcoord_1_y = mopedcoord_1_y - 20.0
				MARK_CAR_AS_NO_LONGER_NEEDED press_moped4 
				GET_RANDOM_CAR_OF_TYPE_IN_AREA mopedcoord_1_x mopedcoord_1_y mopedcoord_2_x mopedcoord_2_y -1 press_moped4
				IF NOT press_moped4 = -1
					LOCK_CAR_DOORS press_moped4 CARLOCK_UNLOCKED
					SET_CAR_CRUISE_SPEED press_moped4 0.0
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER press_driver4 press_moped4
					SET_CHAR_RUNNING press_driver4 TRUE
				ENDIF
			ENDIF
		ELSE
			GET_CLOSEST_CAR_NODE_WITH_HEADING mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z moped_heading
			IF NOT IS_POINT_ON_SCREEN mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z 3.0 3.0 2.0
					MARK_CAR_AS_NO_LONGER_NEEDED press_moped4
					CREATE_CAR faggio mopedcoord_1_x mopedcoord_1_y mopedcoord_1_z press_moped4
					SET_CAR_HEADING	press_moped4 moped_heading
					IF NOT IS_CHAR_IN_ANY_CAR press_driver4 
						WARP_CHAR_INTO_CAR press_driver4 press_moped4
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CAR_DEAD press_moped4
			IF NOT IS_CHAR_DEAD press_driver4 
				IF IS_CHAR_IN_CAR press_driver4 press_moped4 
					SET_CAR_MISSION press_moped4 MISSION_BLOCKPLAYER_CLOSE 
					SET_CAR_DRIVING_STYLE press_moped4 DRIVINGMODE_AVOIDCARS 
					press_driver4_off_moped = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
removing_car_blips:////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
IF NOT IS_CAR_DEAD mexican_car
	REMOVE_BLIP mexican_car_blip
	no_car_blip1 = 1
ENDIF
IF NOT IS_CAR_DEAD mexican_car2
	REMOVE_BLIP mexican_car2_blip
	no_car_blip2 = 1
ENDIF
IF NOT IS_CAR_DEAD mexican_car3
	REMOVE_BLIP mexican_car3_blip
	no_car_blip3 = 1
ENDIF
IF NOT IS_CAR_DEAD mexican_car4
	REMOVE_BLIP mexican_car4_blip
	no_car_blip4 = 1
ENDIF
///////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
}
