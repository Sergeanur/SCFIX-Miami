MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Protection 2************************************
// *****************************************Bar Brawl***************************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME protec2
// Mission start stuff
GOSUB mission_start_protec2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_protec2
ENDIF
GOSUB mission_cleanup_protec2
MISSION_END
 
// Variables for mission
//people, cars and objects
VAR_INT prot_cuban1
VAR_INT prot_cuban2
VAR_INT shop_keep
VAR_INT shop_defend_guard1
VAR_INT shop_defend_guard2
VAR_INT shop_defend_guard3
VAR_INT shop_defend_guard4
VAR_INT shop_defend_guard5
VAR_INT fucked_oceanic
VAR_INT security_gang_leader_bike
VAR_INT no2_bike
VAR_INT free_sentinel
VAR_INT fake_briefcase
VAR_INT fake_briefcase1
VAR_INT fake_briefcase2
VAR_INT dbpvan
VAR_INT dbpvan_driver 
VAR_INT off_bike1
VAR_INT off_bike2
					  
//blips
VAR_INT shop_defend_guard1_blip
VAR_INT shop_defend_guard2_blip
VAR_INT shop_defend_guard3_blip
VAR_INT shop_defend_guard4_blip
VAR_INT shop_defend_guard5_blip
VAR_INT news_cafe_blip

//flags
VAR_INT security_coming_to_get_you
VAR_INT guard2_out_of_news_bar  
VAR_INT flag_leader_on_bike
VAR_INT prot2_speech 
VAR_INT controlling_bike1
VAR_INT controlling_bike2
VAR_INT dbp_time
VAR_INT controlling3
VAR_INT controlling4
VAR_INT controlling5
VAR_INT bonus_flags

//cutscene
VAR_INT cs_drink01
VAR_INT cs_drink02
VAR_INT cs_drink03

// ****************************************Mission Start************************************
mission_start_protec2:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PROT2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -288.2 -487.5 9.8 275.0
// *****************************************Set Flags/variables************************************
security_coming_to_get_you = 0
flag_leader_on_bike = 0 
guard2_out_of_news_bar = 0
button_pressed = 0
prot2_speech = 0
controlling_bike1 = 0
controlling_bike2 = 0
dbp_time = 301000 //5 mins
controlling3 = 0
controlling4 = 0
controlling5 = 0
bonus_flags = 0
off_bike1 = 0
off_bike2 = 0
// ****************************************START OF CUTSCENE********************************
SET_AREA_VISIBLE VIS_MANSION 
REMOVE_PICKUP health_pickup
flag_player_in_mansion = 1

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSbuddy
LOAD_SPECIAL_CHARACTER 3 dgoona
LOAD_SPECIAL_CHARACTER 4 dgoonc
LOAD_SPECIAL_CHARACTER 5 CSavery

LOAD_SPECIAL_MODEL CUTOBJ01 dcfan
LOAD_SPECIAL_MODEL CUTOBJ02 drink

LOAD_SCENE -378.62 -552.676 18.534

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

LOAD_CUTSCENE bud_2
CLEAR_AREA -378.6 -552.6 25.5 15.0 TRUE
CLEAR_AREA -379.0 -564.6 19.8 15.0 TRUE
SET_PED_DENSITY_MULTIPLIER 0.0
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
SET_NEAR_CLIP 0.1
												
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_buddy
SET_CUTSCENE_ANIM cs_buddy CSbuddy

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_dgoona
SET_CUTSCENE_ANIM cs_dgoona dgoona

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_dgoonc
SET_CUTSCENE_ANIM cs_dgoonc dgoonc

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_avery
SET_CUTSCENE_ANIM cs_avery CSavery

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_dcfan
SET_CUTSCENE_ANIM_TO_LOOP dcfan
SET_CUTSCENE_ANIM cs_dcfan dcfan

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drink01
SET_CUTSCENE_ANIM cs_drink01 drink01

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drink02
SET_CUTSCENE_ANIM cs_drink02 drink02

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drink03
SET_CUTSCENE_ANIM cs_drink03 drink03

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE





// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 5914  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW PRO2_A 10000 1 // What's the problem?

WHILE cs_time < 7399
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO2_B 10000 1 // Some bar is refusing to pay.

WHILE cs_time < 9756
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO2_C 10000 1 // They reckon they're protected by a local gang of thugs. 

WHILE cs_time < 12705
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO2_D 10000 1 //But don't worry Tommy, I can handle it.

WHILE cs_time < 16592
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO2_E 10000 1 //You call this handling it?

WHILE cs_time < 19312
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO2_F 10000 1 // You two, off your asses... 

WHILE cs_time < 21275
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO2_G 10000 1 // Let's Go. 

WHILE cs_time < 22275
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 22784
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
//UNLOAD_SPECIAL_CHARACTER 3
//UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02


CREATE_PICKUP health PICKUP_ON_STREET -406.2503 -566.4947 19.5804 health_pickup //in mansion (for chris' finale)
SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_AREA_VISIBLE VIS_MAIN_MAP
flag_player_in_mansion = 0
CLEAR_EXTRA_COLOURS FALSE // FIXMIAMI

// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
SET_PLAYER_COORDINATES player1 -375.9 -544.6 16.2
LOAD_SCENE -375.9 -510.6 16.2 
SET_PLAYER_HEADING player1 360.0
SET_CAMERA_BEHIND_PLAYER
//------------------REQUEST_MODELS ------------------------------
{
SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000

REQUEST_MODEL uzi
REQUEST_MODEL brassknuckle
REQUEST_MODEL m4
REQUEST_MODEL pcj600
REQUEST_MODEL oceanic
REQUEST_MODEL sentinel

WHILE NOT HAS_MODEL_LOADED uzi
OR NOT HAS_MODEL_LOADED brassknuckle
OR NOT HAS_MODEL_LOADED m4
OR NOT HAS_MODEL_LOADED pcj600
OR NOT HAS_MODEL_LOADED oceanic
OR NOT HAS_MODEL_LOADED sentinel
	WAIT 0
ENDWHILE

REQUEST_MODEL GDa
REQUEST_MODEL GDb
REQUEST_MODEL HMOST
REQUEST_MODEL securica

WHILE NOT HAS_MODEL_LOADED GDa
OR NOT HAS_MODEL_LOADED GDb
OR NOT HAS_MODEL_LOADED HMOST
OR NOT HAS_MODEL_LOADED securica
	WAIT 0
ENDWHILE

GOTO prot2_fool_compiler // FIXMIAMI: remove flag_player_on_mission = 0 check
	ADD_BLIP_FOR_COORD 240.9 -1241.8 10.8 news_cafe_blip
prot2_fool_compiler: // FIXMIAMI: remove flag_player_on_mission = 0 check

CREATE_CHAR PEDTYPE_GANG_PLAYER SPECIAL03 -368.8 -544.8 16.2 prot_cuban1
SET_CHAR_AS_PLAYER_FRIEND prot_cuban1 player1 TRUE
GIVE_WEAPON_TO_CHAR prot_cuban1 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH prot_cuban1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER prot_cuban1 TRUE
SET_CHAR_CANT_BE_DRAGGED_OUT prot_cuban1 TRUE
SET_CHAR_PERSONALITY prot_cuban1 PEDSTAT_TOUGH_GUY
SET_CHAR_HEED_THREATS prot_cuban1 TRUE
SET_CHAR_HEADING prot_cuban1 281.0 

CREATE_CHAR PEDTYPE_GANG_PLAYER SPECIAL04 -370.9 -546.8 16.2 prot_cuban2
SET_CHAR_AS_PLAYER_FRIEND prot_cuban2 player1 TRUE
GIVE_WEAPON_TO_CHAR prot_cuban2 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH prot_cuban2
SET_CHAR_ONLY_DAMAGED_BY_PLAYER prot_cuban2 TRUE
SET_CHAR_CANT_BE_DRAGGED_OUT prot_cuban2 TRUE
SET_CHAR_PERSONALITY prot_cuban2 PEDSTAT_TOUGH_GUY
SET_CHAR_HEED_THREATS prot_cuban2 TRUE
SET_CHAR_HEADING prot_cuban2 281.0 

SET_PLAYER_AS_LEADER prot_cuban1 player1
SET_PLAYER_AS_LEADER prot_cuban2 player1
SET_CHAR_RUNNING prot_cuban1 TRUE
SET_CHAR_RUNNING prot_cuban2 TRUE

CREATE_CAR sentinel -345.3 -524.6 11.5 free_sentinel

DO_FADE 1500 FADE_IN

//creating guards at the shop to kill

PRINT_NOW ( PRO2_01 ) 11000 1 //Take out the thugs protecting the Front Page Bar and find out who supplied them.


//fake guys 
CREATE_RANDOM_CHAR 236.8 -1244.0 10.9 shop_defend_guard4
SET_CHAR_HEADING shop_defend_guard4 320.4  
CREATE_RANDOM_CHAR 237.5 -1243.0 10.9 shop_defend_guard5 
SET_CHAR_HEADING shop_defend_guard5 140.3  

SET_CHARS_CHATTING shop_defend_guard4 shop_defend_guard5 86400000 



//Guard 1 - doorman to NEWS BAR

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa 243.1 -1243.4 10.0 shop_defend_guard1
SET_CHAR_HEADING shop_defend_guard1 0.9 
GIVE_WEAPON_TO_CHAR shop_defend_guard1 WEAPONTYPE_UZI 10000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard1
SET_CHAR_PERSONALITY shop_defend_guard1 PEDSTAT_TOUGH_GUY  
ADD_BLIP_FOR_CHAR shop_defend_guard1 shop_defend_guard1_blip
SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard1 TRUE 

//Guard 2 - doorman to NEWS BAR

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb 243.2 -1239.9 10.0 shop_defend_guard2
SET_CHAR_HEADING shop_defend_guard2 194.6 
GIVE_WEAPON_TO_CHAR shop_defend_guard2 WEAPONTYPE_UZI 10000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard2
SET_CHAR_PERSONALITY shop_defend_guard2 PEDSTAT_TOUGH_GUY  						
ADD_BLIP_FOR_CHAR shop_defend_guard2 shop_defend_guard2_blip
SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard2 TRUE 

SET_CHARS_CHATTING shop_defend_guard2 shop_defend_guard1 86400000


//waiting for player to antagonise protection
prot2_loop1:

WAIT 0

IF security_coming_to_get_you = 1
	IF NOT IS_CHAR_DEAD shop_defend_guard4 
		MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard4
	ENDIF 

	IF NOT IS_CHAR_DEAD shop_defend_guard5
		MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard4
	ENDIF
ENDIF 
	 
IF security_coming_to_get_you = 0
	IF NOT IS_CHAR_DEAD shop_defend_guard1   
		IF IS_PLAYER_TARGETTING_CHAR player1 shop_defend_guard1 
			security_coming_to_get_you = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD shop_defend_guard2   
		IF IS_PLAYER_TARGETTING_CHAR player1 shop_defend_guard2 
			security_coming_to_get_you = 1
		ENDIF
	ENDIF
ENDIF
		
IF prot2_speech = 0
	IF NOT IS_CHAR_DEAD prot_cuban1
		IF IS_CHAR_IN_PLAYERS_GROUP prot_cuban1 player1
			IF IS_PLAYER_IN_ANY_CAR player1 
				IF NOT IS_CHAR_SITTING_IN_ANY_CAR prot_cuban1
					IF NOT IS_PLAYER_ON_ANY_BIKE player1 
						IF NOT IS_PLAYER_IN_ANY_HELI player1 
							LOAD_MISSION_AUDIO 1 BUD2_1

							WHILE NOT HAS_MISSION_AUDIO_LOADED 1
								WAIT 0
							ENDWHILE 
							PRINT_NOW PRO2_11 4000 1//Get in the car, useless.
							PLAY_MISSION_AUDIO 1
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
							AND NOT IS_CHAR_DEAD prot_cuban1  
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT PRO2_11
							prot2_speech = 1
						ENDIF
					ENDIF 
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
			   
IF NOT IS_CHAR_DEAD shop_defend_guard1   
	IF NOT IS_CHAR_HEALTH_GREATER shop_defend_guard1 95
		IF security_coming_to_get_you = 0
			security_coming_to_get_you = 1
		ENDIF
	ENDIF	
	IF security_coming_to_get_you = 1
		SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard1 FALSE 
		SET_CHAR_THREAT_SEARCH shop_defend_guard1 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH shop_defend_guard1 THREAT_GANG_PLAYER
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shop_defend_guard1 player1
	ENDIF
ELSE
	IF security_coming_to_get_you = 0 
		security_coming_to_get_you = 1
	ENDIF
	REMOVE_BLIP shop_defend_guard1_blip 
	MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard1 
ENDIF 

IF NOT IS_CHAR_DEAD shop_defend_guard2   
	IF NOT IS_CHAR_HEALTH_GREATER shop_defend_guard2 95
		IF security_coming_to_get_you = 0
			security_coming_to_get_you = 1
		ENDIF
	ENDIF	
	IF security_coming_to_get_you = 1
		SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard2 FALSE 
		IF guard2_out_of_news_bar = 0
			IF NOT LOCATE_CHAR_ANY_MEANS_2D shop_defend_guard2 240.2 -1241.8 1.0 1.0 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard2 240.2 -1241.8
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard2 242.9 -1241.5 
				guard2_out_of_news_bar = 1
			ENDIF
		ENDIF
		IF guard2_out_of_news_bar = 1
			IF NOT LOCATE_CHAR_ANY_MEANS_2D shop_defend_guard2 242.9 -1241.5 1.0 1.0 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard2 242.9 -1241.5
			ELSE
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS shop_defend_guard2 player1 
				guard2_out_of_news_bar = 2
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF security_coming_to_get_you = 0 
		security_coming_to_get_you = 1
	ENDIF
	REMOVE_BLIP shop_defend_guard2_blip 
	MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard2 
ENDIF 



//waiting for player to kill both guards

IF IS_CHAR_DEAD shop_defend_guard1
	IF IS_CHAR_DEAD shop_defend_guard2
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 240.9 -1241.8 10.8 1.0 1.0 2.0 TRUE
// ****************************************START OF CUTSCENE - player speaking to shop keeper********************************
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			REMOVE_BLIP news_cafe_blip
			CLEAR_SMALL_PRINTS
			
		  	CREATE_CHAR PEDTYPE_CIVMALE HMOST 235.6 -1236.0 13.3 shop_keep
			CLEAR_CHAR_THREAT_SEARCH shop_keep
			SET_CHAR_OBJ_GOTO_CHAR_ON_FOOT shop_keep scplayer   
			TURN_CHAR_TO_FACE_COORD scplayer 233.1 -1240.6 11.9
			SET_CHAR_NEVER_TARGETTED shop_keep TRUE

			SET_FIXED_CAMERA_POSITION 245.88 -1241.78 13.24 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT 240.75 -1241.51 11.93 JUMP_CUT
			timera = 0

		   //waiting for player1 to reach shop keeper

			locate_player_char_loop:

			WAIT 0 

			IF NOT IS_CHAR_DEAD shop_keep 
				IF NOT IS_CHAR_DEAD prot_cuban1
					IF LOCATE_CHAR_ON_FOOT_CHAR_2D prot_cuban1 shop_keep 5.0 5.0 FALSE
						LEAVE_GROUP prot_cuban1 
						SET_CHAR_HEED_THREATS prot_cuban1 FALSE
						SET_CHAR_STAY_IN_SAME_PLACE prot_cuban1 TRUE
					ENDIF
				ENDIF  
				
				IF NOT IS_CHAR_DEAD prot_cuban2
					IF LOCATE_CHAR_ON_FOOT_CHAR_2D prot_cuban2 shop_keep 5.0 5.0 FALSE 
						LEAVE_GROUP prot_cuban2 
						SET_CHAR_HEED_THREATS prot_cuban2 FALSE
						SET_CHAR_STAY_IN_SAME_PLACE prot_cuban2 TRUE
					ENDIF
				ENDIF  
			 
				IF LOCATE_CHAR_ON_FOOT_CHAR_2D scplayer shop_keep 2.0 2.0 FALSE
				OR timera > 2000  

					WAIT 500 
					
					IF NOT IS_CHAR_DEAD shop_keep 
						SET_CHAR_OBJ_NO_OBJ shop_keep
						TURN_CHAR_TO_FACE_PLAYER shop_keep player1
						TURN_CHAR_TO_FACE_CHAR scplayer shop_keep 
					ENDIF 

					SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000
				
					LOAD_MISSION_AUDIO 1 BUD2_2
					LOAD_MISSION_AUDIO 2 BUD2_3

					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					OR NOT HAS_MISSION_AUDIO_LOADED 2
						WAIT 0
					ENDWHILE 

					PRINT_NOW PRO2_02 4000 1//PLAYER: Your protection needs a little more protection.
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 CROSS
							IF button_pressed = 1
								button_pressed = 0
								GOTO end_cut_prot2_1
							ENDIF
						ELSE
							IF button_pressed = 0
								button_pressed = 1
							ENDIF
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PRO2_02 

					SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
					
					IF NOT IS_CHAR_DEAD shop_keep 
						SET_CHAR_WAIT_STATE shop_keep WAITSTATE_PLAYANIM_CHAT 20000
					ENDIF
				
					PRINT_NOW PRO2_03 4000 1//SHOPKEEP: Aw hell, not again! I don't need this crap!
					PLAY_MISSION_AUDIO 2
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD shop_keep  
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 CROSS
							IF button_pressed = 1
								button_pressed = 0
								GOTO end_cut_prot2_1
							ENDIF
						ELSE
							IF button_pressed = 0
								button_pressed = 1
							ENDIF
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 2
					CLEAR_THIS_PRINT PRO2_03 


					LOAD_MISSION_AUDIO 1 BUD2_4
					LOAD_MISSION_AUDIO 2 BUD2_5

					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					OR NOT HAS_MISSION_AUDIO_LOADED 2
						WAIT 0
					ENDWHILE 

					PRINT_NOW PRO2_04 4000 1//SHOPKEEP: These idiots operate out of DBP Security around the block.
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD shop_keep  
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 CROSS
							IF button_pressed = 1
								button_pressed = 0
								GOTO end_cut_prot2_1
							ENDIF
						ELSE
							IF button_pressed = 0
								button_pressed = 1
							ENDIF
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PRO2_04 
				
					PRINT_NOW PRO2_05 4000 1//SHOPKEEP: You guys just sort it out amongst yourselves.
					PLAY_MISSION_AUDIO 2
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD shop_keep  
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 CROSS
							IF button_pressed = 1
								button_pressed = 0
								GOTO end_cut_prot2_1
							ENDIF
						ELSE
							IF button_pressed = 0
								button_pressed = 1
							ENDIF
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 2
					CLEAR_THIS_PRINT PRO2_05 
				
					IF NOT IS_CHAR_DEAD shop_keep 
						SET_CHAR_WAIT_STATE shop_keep WAITSTATE_FALSE 100
					ENDIF
					
					SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

					LOAD_MISSION_AUDIO 1 BUD2_6
					LOAD_MISSION_AUDIO 2 BUD2_7

					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					OR NOT HAS_MISSION_AUDIO_LOADED 2
						WAIT 0
					ENDWHILE 
			
					PRINT_NOW PRO2_06 4000 1//PLAYER: I'll be seeing you later.
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 CROSS
							IF button_pressed = 1
								button_pressed = 0
								GOTO end_cut_prot2_1
							ENDIF
						ELSE
							IF button_pressed = 0
								button_pressed = 1
							ENDIF
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT PRO2_06 
				
					SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
				
					IF NOT IS_CHAR_DEAD shop_keep 
						SET_CHAR_WAIT_STATE shop_keep WAITSTATE_PLAYANIM_CHAT 20000
					ENDIF
					PRINT_NOW PRO2_07 4000 1//SHOPKEEP: Yeah, yeah, whatever.
					PLAY_MISSION_AUDIO 2
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD shop_keep  
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 CROSS
							IF button_pressed = 1
								button_pressed = 0
								GOTO end_cut_prot2_1
							ENDIF
						ELSE
							IF button_pressed = 0
								button_pressed = 1
							ENDIF
						ENDIF
					ENDWHILE
					CLEAR_MISSION_AUDIO 2
					CLEAR_THIS_PRINT PRO2_07 
					
					end_cut_prot2_1:
					CLEAR_SMALL_PRINTS
					CLEAR_MISSION_AUDIO 1
					CLEAR_MISSION_AUDIO 2
					SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
					IF NOT IS_CHAR_DEAD shop_keep 
						SET_CHAR_WAIT_STATE shop_keep WAITSTATE_FALSE 100
					ENDIF
					IF NOT IS_CHAR_DEAD prot_cuban1
						SET_CHAR_HEED_THREATS prot_cuban1 TRUE
						SET_CHAR_STAY_IN_SAME_PLACE prot_cuban1 FALSE
						SET_PLAYER_AS_LEADER prot_cuban1 player1
					ENDIF
					IF NOT IS_CHAR_DEAD prot_cuban2
						SET_CHAR_HEED_THREATS prot_cuban2 TRUE
						SET_CHAR_STAY_IN_SAME_PLACE prot_cuban2 FALSE
						SET_PLAYER_AS_LEADER prot_cuban2 player1
					ENDIF
		
					SET_CHAR_OBJ_NO_OBJ scplayer
					IF NOT IS_CHAR_DEAD shop_keep 
						SET_CHAR_OBJ_NO_OBJ shop_keep
					ENDIF
					
					RESTORE_CAMERA_JUMPCUT
					SET_PLAYER_CONTROL player1 ON
					SWITCH_WIDESCREEN OFF

					PRINT_NOW PRO2_08 11000 1//DBP Security will know you are on your way, go and get them before they clear out.
					DISPLAY_ONSCREEN_TIMER dbp_time TIMER_DOWN
					security_coming_to_get_you = 0
					GOTO prot2_loop1_finish
				ENDIF
			ENDIF

			GOTO locate_player_char_loop
		  
// ****************************************END OF CUTSCENE  - player speaking to shop keeper ********************************
		ELSE
			IF security_coming_to_get_you = 1
				PRINT_NOW ( PRO2_09 ) 11000 1 //Go and speak to the News Cafe Owner.
				ADD_BLIP_FOR_COORD 240.9 -1241.8 10.8 news_cafe_blip 
				security_coming_to_get_you = 2
			ENDIF
		ENDIF
	ENDIF
ENDIF
		   
GOTO prot2_loop1 

prot2_loop1_finish:

//oceanic car 

CREATE_CAR oceanic 346.8 -727.1 9.1 fucked_oceanic  
SET_CAR_HEADING fucked_oceanic 247.9 
POP_CAR_BOOT fucked_oceanic
CREATE_OBJECT briefcase 346.8 -727.1 9.1 fake_briefcase
CREATE_OBJECT briefcase 346.8 -727.1 9.1 fake_briefcase1
CREATE_OBJECT briefcase 346.8 -727.1 9.1 fake_briefcase2
SET_OBJECT_COLLISION fake_briefcase FALSE
SET_OBJECT_COLLISION fake_briefcase1 FALSE
SET_OBJECT_COLLISION fake_briefcase2 FALSE

//Guard 1 - security doorman - front right of employees only door when looking at it

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb 353.4 -732.9 9.6 shop_defend_guard1
SET_CHAR_HEADING shop_defend_guard1 339.7 
GIVE_WEAPON_TO_CHAR shop_defend_guard1 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard1
SET_CHAR_PERSONALITY shop_defend_guard1 PEDSTAT_TOUGH_GUY  
ADD_BLIP_FOR_CHAR shop_defend_guard1 shop_defend_guard1_blip
SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard1 TRUE 
SET_CHAR_ACCURACY shop_defend_guard1 90 
SET_CHAR_HEALTH shop_defend_guard1 150 

//Guard 2 - security doorman - front left of employees only door when looking at it

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa 350.6 -731.9 9.6 shop_defend_guard2
SET_CHAR_HEADING shop_defend_guard2 339.2 
GIVE_WEAPON_TO_CHAR shop_defend_guard2 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard2
SET_CHAR_PERSONALITY shop_defend_guard2 PEDSTAT_TOUGH_GUY  
ADD_BLIP_FOR_CHAR shop_defend_guard2 shop_defend_guard2_blip
SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard2 TRUE 
SET_CHAR_ACCURACY shop_defend_guard2 90 
SET_CHAR_HEALTH shop_defend_guard2 150 

//Guard 3 - security doorman - front left tyre of car

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa 349.1 -726.2 9.6 shop_defend_guard3
SET_CHAR_HEADING shop_defend_guard3 148.2 
GIVE_WEAPON_TO_CHAR shop_defend_guard3 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard3
SET_CHAR_PERSONALITY shop_defend_guard3 PEDSTAT_TOUGH_GUY  
ADD_BLIP_FOR_CHAR shop_defend_guard3 shop_defend_guard3_blip
SET_CHAR_ACCURACY shop_defend_guard3 90 
SET_CHAR_HEALTH shop_defend_guard3 150 

SET_CHAR_CROUCH shop_defend_guard3 TRUE 86400000 

//Guard 4 - security doorman - standing at boot of car chatting to shop_defend_guard5

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb 343.7 -725.2 9.2 shop_defend_guard4
SET_CHAR_HEADING shop_defend_guard4 190.7 
GIVE_WEAPON_TO_CHAR shop_defend_guard4 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard4
SET_CHAR_PERSONALITY shop_defend_guard4 PEDSTAT_TOUGH_GUY  
ADD_BLIP_FOR_CHAR shop_defend_guard4 shop_defend_guard4_blip
SET_CHAR_ACCURACY shop_defend_guard4 90 
SET_CHAR_HEALTH shop_defend_guard4 150 

//Guard 5 - security doorman - standing at boot of car chatting to shop_defend_guard4

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa 343.2 -726.4 9.2 shop_defend_guard5
SET_CHAR_HEADING shop_defend_guard5 1.8 
GIVE_WEAPON_TO_CHAR shop_defend_guard5 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard5
SET_CHAR_PERSONALITY shop_defend_guard5 PEDSTAT_TOUGH_GUY  
ADD_BLIP_FOR_CHAR shop_defend_guard5 shop_defend_guard5_blip
SET_CHAR_ACCURACY shop_defend_guard5 90 
SET_CHAR_HEALTH shop_defend_guard5 150 

SET_CHARS_CHATTING shop_defend_guard4 shop_defend_guard5 86400000

timerb = 0



fighting_dbp_security:
WAIT 0

IF dbp_time = 0
	PRINT_NOW ( TAXI2 ) 5000 1 //Out of time
	GOTO mission_failed_protec2
ENDIF


IF NOT IS_CAR_DEAD fucked_oceanic 
	IF IS_PLAYER_IN_CAR player1 fucked_oceanic
		IF security_coming_to_get_you = 0
			security_coming_to_get_you = 1
		ENDIF
	ENDIF 
	PLACE_OBJECT_RELATIVE_TO_CAR fake_briefcase fucked_oceanic 0.0 -2.0 0.0
	PLACE_OBJECT_RELATIVE_TO_CAR fake_briefcase1 fucked_oceanic 0.0 -2.2 0.0
	PLACE_OBJECT_RELATIVE_TO_CAR fake_briefcase2 fucked_oceanic 0.0 -2.4 0.0
ENDIF

IF NOT IS_CHAR_DEAD shop_defend_guard1 
	IF timera > 500
		IF HAS_CHAR_SPOTTED_PLAYER shop_defend_guard1 player1 
			security_coming_to_get_you = 1
			timerb = 0
		ENDIF
	ENDIF	 
	
	IF NOT IS_CHAR_HEALTH_GREATER shop_defend_guard1 95
		IF security_coming_to_get_you = 0
			security_coming_to_get_you = 1
		ENDIF
	ENDIF	
	IF security_coming_to_get_you = 1
		SET_CHAR_THREAT_SEARCH shop_defend_guard1 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH shop_defend_guard1 THREAT_GANG_PLAYER
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shop_defend_guard1 player1
	ENDIF
ELSE
	security_coming_to_get_you = 1
	REMOVE_BLIP shop_defend_guard1_blip 
	MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard1 
ENDIF 

IF NOT IS_CHAR_DEAD shop_defend_guard2   
	IF NOT IS_CHAR_HEALTH_GREATER shop_defend_guard2 95
		IF security_coming_to_get_you = 0
			security_coming_to_get_you = 1
		ENDIF
	ENDIF	
	IF security_coming_to_get_you = 1
		SET_CHAR_THREAT_SEARCH shop_defend_guard2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH shop_defend_guard2 THREAT_GANG_PLAYER
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shop_defend_guard2 player1
	ENDIF
ELSE
	security_coming_to_get_you = 1
	REMOVE_BLIP shop_defend_guard2_blip 
	MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard2 
ENDIF 

IF NOT IS_CHAR_DEAD shop_defend_guard3   
	IF NOT IS_CHAR_HEALTH_GREATER shop_defend_guard3 95
		IF security_coming_to_get_you = 0
			security_coming_to_get_you = 1
		ENDIF
	ENDIF
	IF controlling3 = 0 
		IF security_coming_to_get_you = 1
			SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard3 FALSE 
			SET_CHAR_THREAT_SEARCH shop_defend_guard3 THREAT_PLAYER1
			SET_CHAR_THREAT_SEARCH shop_defend_guard3 THREAT_GANG_PLAYER
			controlling3 = 1
		ENDIF
	ENDIF
	IF controlling3 = 1
		SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard3 355.6 -726.0
		controlling3 = 2
	ENDIF
	IF controlling3 = 2
		IF LOCATE_CHAR_ANY_MEANS_2D shop_defend_guard3 355.6 -726.0 2.0 2.0 FALSE
			SET_CHAR_OBJ_NO_OBJ shop_defend_guard3   
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shop_defend_guard3 player1
			controlling3 = 3
		ENDIF
	ENDIF
ELSE
	security_coming_to_get_you = 1
	REMOVE_BLIP shop_defend_guard3_blip 
	MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard3 
ENDIF 

IF NOT IS_CHAR_DEAD shop_defend_guard4   
	IF NOT IS_CHAR_HEALTH_GREATER shop_defend_guard4 95
		IF security_coming_to_get_you = 0
			security_coming_to_get_you = 1
		ENDIF
	ENDIF	
	IF controlling4 = 0 
		IF security_coming_to_get_you = 1
			SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard4 FALSE 
			SET_CHAR_THREAT_SEARCH shop_defend_guard4 THREAT_PLAYER1
			SET_CHAR_THREAT_SEARCH shop_defend_guard4 THREAT_GANG_PLAYER
			controlling4 = 1
		ENDIF
	ENDIF
	IF controlling4 = 1
		SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard4 355.6 -726.0
		controlling4 = 2
	ENDIF
	IF controlling4 = 2
		IF LOCATE_CHAR_ANY_MEANS_2D shop_defend_guard4 355.6 -726.0 2.0 2.0 FALSE  
			SET_CHAR_OBJ_NO_OBJ shop_defend_guard4   
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shop_defend_guard4 player1
			controlling4 = 3
		ENDIF
	ENDIF
ELSE
	security_coming_to_get_you = 1
	REMOVE_BLIP shop_defend_guard4_blip 
	MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard4 
ENDIF 

IF NOT IS_CHAR_DEAD shop_defend_guard5   
	IF NOT IS_CHAR_HEALTH_GREATER shop_defend_guard5 95
		IF security_coming_to_get_you = 0
			security_coming_to_get_you = 1
		ENDIF
	ENDIF	
	IF controlling5 = 0 
		IF security_coming_to_get_you = 1
			SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard5 FALSE 
			SET_CHAR_THREAT_SEARCH shop_defend_guard5 THREAT_PLAYER1
			SET_CHAR_THREAT_SEARCH shop_defend_guard5 THREAT_GANG_PLAYER
			controlling5 = 1
		ENDIF
	ENDIF
	IF controlling5 = 1
		SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard5 355.6 -726.0
		controlling5 = 2
	ENDIF
	IF controlling5 = 2
		IF LOCATE_CHAR_ANY_MEANS_2D shop_defend_guard5 355.6 -726.0 2.0 2.0 FALSE  
			SET_CHAR_OBJ_NO_OBJ shop_defend_guard5   
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shop_defend_guard5 player1
			controlling5 = 3
		ENDIF
	ENDIF
ELSE
	security_coming_to_get_you = 1
	REMOVE_BLIP shop_defend_guard5_blip 
	MARK_CHAR_AS_NO_LONGER_NEEDED shop_defend_guard5 
ENDIF 

IF IS_CHAR_DEAD shop_defend_guard1
	IF IS_CHAR_DEAD shop_defend_guard2
		IF IS_CHAR_DEAD shop_defend_guard3
			IF IS_CHAR_DEAD shop_defend_guard4
				IF IS_CHAR_DEAD shop_defend_guard5
					MARK_CAR_AS_NO_LONGER_NEEDED fucked_oceanic
					security_coming_to_get_you = 0
					GOTO the_chase_starts
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF		 

GOTO fighting_dbp_security 

the_chase_starts:

WAIT 2000

// ****************************************START OF CUTSCENE - start of the chase********************************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

CLEAR_AREA_OF_CARS 347.3 -703.4 5.0 397.4 -773.0 20.0
SET_FIXED_CAMERA_POSITION 353.54 -719.07 13.89 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 365.18 -730.36 10.99 JUMP_CUT

SET_CHAR_OBJ_RUN_TO_COORD scplayer 356.8 -724.7
WAIT 1000

ADD_EXPLOSION 366.4 -730.3 9.0 EXPLOSION_ROCKET
ADD_EXPLOSION 366.4 -730.3 9.0 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION 366.4 -730.3 9.0 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 366.4 -730.3 9.0 0.1 0.0 0.2 0.8 0 0 0 11000 

WAIT 500

//Gang Leader
CREATE_CAR pcj600 359.0 -742.1 10.0 security_gang_leader_bike  
SET_CAR_HEADING security_gang_leader_bike 332.8 
SET_CAR_DRIVING_STYLE security_gang_leader_bike 2
SET_CAR_CRUISE_SPEED security_gang_leader_bike 0.0 
SET_CAR_ONLY_DAMAGED_BY_PLAYER security_gang_leader_bike TRUE  
SET_CAR_PROOFS security_gang_leader_bike TRUE TRUE TRUE TRUE TRUE

CREATE_CHAR_INSIDE_CAR security_gang_leader_bike PEDTYPE_CIVMALE GDb shop_defend_guard1 // FIXMIAMI: was PEDTYPE_CIVFEMALE
GIVE_WEAPON_TO_CHAR shop_defend_guard1 WEAPONTYPE_M4 30000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard1
SET_CHAR_PERSONALITY shop_defend_guard1 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH shop_defend_guard1 THREAT_PLAYER1 
SET_CHAR_THREAT_SEARCH shop_defend_guard1 THREAT_GANG_PLAYER
SET_CHAR_RUNNING shop_defend_guard1 TRUE
SET_CHAR_PROOFS shop_defend_guard1 TRUE TRUE TRUE TRUE TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER shop_defend_guard1 TRUE  
SET_CHAR_HEALTH shop_defend_guard1 150 
ADD_BLIP_FOR_CHAR shop_defend_guard1 shop_defend_guard1_blip 

SET_CHAR_HEED_THREATS shop_defend_guard1 TRUE 


//Gang No.2
CREATE_CAR pcj600 357.5 -745.2 10.0 no2_bike  
SET_CAR_HEADING no2_bike 332.8 
SET_CAR_DRIVING_STYLE no2_bike 3 
SET_CAR_CRUISE_SPEED no2_bike 0.0  
SET_CAR_ONLY_DAMAGED_BY_PLAYER no2_bike TRUE  
SET_CAR_PROOFS no2_bike TRUE TRUE TRUE TRUE TRUE

CREATE_CHAR_INSIDE_CAR no2_bike PEDTYPE_CIVMALE GDa shop_defend_guard2 // FIXMIAMI: was PEDTYPE_CIVFEMALE
GIVE_WEAPON_TO_CHAR shop_defend_guard2 WEAPONTYPE_M4 30000
CLEAR_CHAR_THREAT_SEARCH shop_defend_guard2
SET_CHAR_PERSONALITY shop_defend_guard2 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH shop_defend_guard2 THREAT_PLAYER1 
SET_CHAR_THREAT_SEARCH shop_defend_guard2 THREAT_GANG_PLAYER
SET_CHAR_RUNNING shop_defend_guard2 TRUE
SET_CHAR_PROOFS shop_defend_guard2 TRUE TRUE TRUE TRUE TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER shop_defend_guard2 TRUE  
SET_CHAR_HEALTH shop_defend_guard1 150 
ADD_BLIP_FOR_CHAR shop_defend_guard2 shop_defend_guard2_blip 


MARK_CAR_AS_CONVOY_CAR security_gang_leader_bike TRUE 
SET_CAR_STRAIGHT_LINE_DISTANCE security_gang_leader_bike 255 
MARK_CAR_AS_CONVOY_CAR no2_bike TRUE 
SET_CAR_STRAIGHT_LINE_DISTANCE no2_bike 255 


SET_CHAR_HEED_THREATS shop_defend_guard2 TRUE 


//ramming car
CREATE_CAR securica 250.8 -1292.2 10.0 dbpvan  
SET_CAR_HEADING dbpvan 347.7 
SET_CAR_DRIVING_STYLE dbpvan 2
SET_CAR_CRUISE_SPEED dbpvan 0.0 
SET_CAR_STRAIGHT_LINE_DISTANCE dbpvan 15 
LOCK_CAR_DOORS dbpvan CARLOCK_LOCKED
CREATE_CHAR_INSIDE_CAR dbpvan PEDTYPE_CIVMALE GDa dbpvan_driver // FIXMIAMI: was PEDTYPE_CIVFEMALE
GIVE_WEAPON_TO_CHAR dbpvan_driver WEAPONTYPE_M4 30000
CLEAR_CHAR_THREAT_SEARCH dbpvan_driver
SET_CHAR_PERSONALITY dbpvan_driver PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH dbpvan_driver THREAT_PLAYER1 
SET_CHAR_THREAT_SEARCH dbpvan_driver THREAT_GANG_PLAYER
SET_CHAR_RUNNING dbpvan_driver TRUE

IF NOT IS_CAR_DEAD security_gang_leader_bike 
	CAR_GOTO_COORDINATES security_gang_leader_bike 368.4 -726.3 10.1  
	SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
ENDIF

IF NOT IS_CAR_DEAD no2_bike 
	CAR_GOTO_COORDINATES no2_bike 368.4 -726.3 10.1  
	SET_CAR_CRUISE_SPEED no2_bike 15.0
ENDIF

IF NOT IS_CAR_DEAD security_gang_leader_bike
	POINT_CAMERA_AT_CAR security_gang_leader_bike FIXED JUMP_CUT
ENDIF
timera = 0

waiting_on_bikes_appearing:
WAIT 0 
IF NOT IS_CAR_DEAD security_gang_leader_bike 
	IF LOCATE_CAR_2D security_gang_leader_bike 368.4 -726.3 2.0 2.0 FALSE
		CAR_GOTO_COORDINATES security_gang_leader_bike 391.7 -743.9 10.9  
		controlling_bike1 = 1
	ENDIF
ENDIF 
IF NOT IS_CAR_DEAD no2_bike 
	IF LOCATE_CAR_2D no2_bike 368.4 -726.3 2.0 2.0 FALSE
		CAR_GOTO_COORDINATES no2_bike 391.7 -743.9 10.9  
		SET_CAR_CRUISE_SPEED no2_bike 23.0
		controlling_bike2 = 1
	ENDIF
ENDIF

IF controlling_bike1 = 1
AND controlling_bike2 = 1 
	GOTO the_1st_chase
ENDIF

IF timera > 5000
	GOTO the_1st_chase
ENDIF	

GOTO waiting_on_bikes_appearing

the_1st_chase:
security_coming_to_get_you = 0
IF controlling_bike1 = 0
	CAR_GOTO_COORDINATES security_gang_leader_bike 391.7 -743.9 10.9
ENDIF
IF controlling_bike2 = 0
	CAR_GOTO_COORDINATES no2_bike 391.7 -743.9 10.9
ENDIF
controlling_bike1 = 0
controlling_bike2 = 0
IF NOT IS_CAR_DEAD security_gang_leader_bike 
	SET_CAR_PROOFS security_gang_leader_bike FALSE FALSE FALSE FALSE FALSE
ENDIF
IF NOT IS_CAR_DEAD no2_bike 
	SET_CAR_PROOFS no2_bike FALSE FALSE FALSE FALSE FALSE
ENDIF
IF NOT IS_CHAR_DEAD shop_defend_guard1 
	SET_CHAR_PROOFS shop_defend_guard1 FALSE FALSE FALSE FALSE FALSE
ENDIF
IF NOT IS_CHAR_DEAD shop_defend_guard2 
	SET_CHAR_PROOFS shop_defend_guard2 FALSE FALSE FALSE FALSE FALSE
ENDIF
WAIT 2000
SET_CHAR_OBJ_NO_OBJ scplayer

PRINT_NOW ( PRO2_10 ) 5000 1 //Two more have made a run for it.  Track them down and finish this.
SET_ENTER_CAR_RANGE_MULTIPLIER 3.5
SET_CHAR_OBJ_NO_OBJ scplayer
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
IF NOT IS_CAR_DEAD dbpvan
	SET_CAR_CRUISE_SPEED dbpvan 100.0 
	SET_CAR_MISSION dbpvan MISSION_RAMPLAYER_FARAWAY
ENDIF
// ****************************************END OF CUTSCENE - start of the chase**********************************************

chase_to_lighthouse:
WAIT 0 

IF bonus_flags = 0
	IF IS_CAR_DEAD dbpvan 
		PRINT_WITH_NUMBER_BIG BONUS 1000 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 1000
		bonus_flags = 1
	ENDIF
ENDIF

IF dbp_time = 0
	PRINT_NOW ( TAXI2 ) 5000 1 //Out of time
	GOTO mission_failed_protec2
ENDIF

IF NOT IS_CAR_DEAD fucked_oceanic 
	PLACE_OBJECT_RELATIVE_TO_CAR fake_briefcase fucked_oceanic 0.0 -2.0 0.0
	PLACE_OBJECT_RELATIVE_TO_CAR fake_briefcase1 fucked_oceanic 0.0 -2.2 0.0
	PLACE_OBJECT_RELATIVE_TO_CAR fake_briefcase2 fucked_oceanic 0.0 -2.4 0.0
ENDIF

IF NOT IS_CHAR_DEAD shop_defend_guard1
	IF NOT IS_CAR_DEAD security_gang_leader_bike
		IF IS_CHAR_IN_CAR shop_defend_guard1 security_gang_leader_bike 
			IF controlling_bike1 = 0
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES security_gang_leader_bike 391.7 -743.9 10.9
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 391.7 -743.9 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 300.3 -955.4 10.8
					controlling_bike1 = 1
				ENDIF
			ENDIF

			IF controlling_bike1 = 1
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 300.3 -955.4 10.8
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 300.3 -955.4 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 285.3 -1048.8 11.3
					controlling_bike1 = 2
				ENDIF
			ENDIF
			
			IF controlling_bike1 = 2
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 285.3 -1048.8 10.8
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 285.3 -1048.8 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 257.9 -1206.8 11.3
					controlling_bike1 = 3
				ENDIF
			ENDIF	
			
			IF controlling_bike1 = 3
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 257.9 -1206.8 10.8
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 257.9 -1206.8 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 234.4 -1326.1 11.3
					controlling_bike1 = 4
				ENDIF
			ENDIF	
		
			IF controlling_bike1 = 4
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 234.4 -1326.1 10.8
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 234.4 -1326.1 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 220.7 -1398.6 11.3
					controlling_bike1 = 5
				ENDIF
			ENDIF	

			IF controlling_bike1 = 5
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 220.7 -1398.6 11.3
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 220.7 -1398.6 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 169.0 -1525.2 11.3
					controlling_bike1 = 6
				ENDIF
			ENDIF	

			IF controlling_bike1 = 6
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 169.0 -1525.2 10.8
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 169.0 -1525.2 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 192.8 -1583.0 11.3
					controlling_bike1 = 7
				ENDIF
			ENDIF	

			IF controlling_bike1 = 7
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 192.8 -1583.0 10.8
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 192.8 -1583.0 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 240.5 -1689.2 11.3
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 15.0
					controlling_bike1 = 8
				ENDIF
			ENDIF	

			IF controlling_bike1 = 8
				IF off_bike1 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard1 
					CAR_GOTO_COORDINATES_ACCURATE security_gang_leader_bike 240.5 -1689.2 10.8
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 25.0
					off_bike1 = 0
				ENDIF
				IF LOCATE_CAR_2D security_gang_leader_bike 240.5 -1689.2 7.0 7.0 FALSE
					SET_CAR_TEMP_ACTION security_gang_leader_bike TEMPACT_HANDBRAKESTRAIGHT 10000 
					SET_CAR_CRUISE_SPEED security_gang_leader_bike 0.0
					SET_CAR_ONLY_DAMAGED_BY_PLAYER security_gang_leader_bike FALSE
					controlling_bike1 = 9
				ENDIF
			ENDIF
		
			IF controlling_bike1 = 9
				SET_CHAR_OBJ_LEAVE_CAR shop_defend_guard1 security_gang_leader_bike
				SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard1 258.7 -1703.0 
				timera = 0
				controlling_bike1 = 10   
			ENDIF
		
			IF controlling_bike1 > 9
				controlling_bike1 = 9
			ENDIF
		ELSE
			IF controlling_bike1 < 9 
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 shop_defend_guard1 10.0 10.0 FALSE 
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS shop_defend_guard1 player1
				ELSE
					IF LOCATE_CHAR_ANY_MEANS_CAR_2D shop_defend_guard1 security_gang_leader_bike 30.0 30.0 FALSE 
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER shop_defend_guard1 security_gang_leader_bike
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS shop_defend_guard1 player1
					ENDIF
				ENDIF 
				off_bike1 = 1
			ELSE
				IF controlling_bike2 = 9
					IF IS_CHAR_IN_CAR shop_defend_guard1 security_gang_leader_bike 
						SET_CHAR_OBJ_LEAVE_CAR shop_defend_guard1 security_gang_leader_bike
					ENDIF
						SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard1 258.7 -1703.0 
					timera = 0
					controlling_bike2 = 10   
				ENDIF
				IF controlling_bike1 = 10
					IF NOT LOCATE_CHAR_ANY_MEANS_2D shop_defend_guard1 454.3 -1727.9 5.0 5.0 FALSE  
						IF timera > 500
							IF NOT IS_CHAR_WANDER_PATH_CLEAR shop_defend_guard1 454.3 -1727.9 9.0 1.0
								CHAR_FOLLOW_PATH shop_defend_guard1 454.3 -1727.9 9.0 1.0 RUN
							ENDIF
							timera = 0
						ENDIF
					ELSE
						SET_CHAR_OBJ_NO_OBJ shop_defend_guard1
						SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard1 TRUE
						controlling_bike1 = 11
					ENDIF
				ENDIF
				IF controlling_bike1 = 11
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shop_defend_guard1 player1
					controlling_bike1 = 12
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CAR_AS_NO_LONGER_NEEDED security_gang_leader_bike 
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS shop_defend_guard1 player1
	ENDIF
ELSE
	REMOVE_BLIP shop_defend_guard1_blip 
ENDIF 


IF NOT IS_CHAR_DEAD shop_defend_guard2
	IF NOT IS_CAR_DEAD no2_bike
		IF IS_CHAR_IN_CAR shop_defend_guard2 no2_bike 
			
			IF controlling_bike2 = 0
				IF off_bike2 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 391.7 -743.9 10.9
					SET_CAR_CRUISE_SPEED no2_bike 23.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 391.7 -743.9 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE no2_bike 300.3 -955.4 10.8
					controlling_bike2 = 1
				ENDIF
			ENDIF

			IF controlling_bike2 = 1
				IF off_bike2 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 300.3 -955.4 10.9
					SET_CAR_CRUISE_SPEED no2_bike 23.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 300.3 -955.4 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE no2_bike 285.3 -1048.8 11.3
					controlling_bike2 = 2
				ENDIF
			ENDIF
			
			IF controlling_bike2 = 2
				IF off_bike2 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 285.3 -1048.8 10.9
					SET_CAR_CRUISE_SPEED no2_bike 23.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 285.3 -1048.8 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE no2_bike 257.9 -1206.8 11.3
					controlling_bike2 = 3
				ENDIF
			ENDIF	
			
			IF controlling_bike2 = 3
				IF off_bike2 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 257.9 -1206.8 10.9
					SET_CAR_CRUISE_SPEED no2_bike 23.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 257.9 -1206.8 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE no2_bike 234.4 -1326.1 11.3
					controlling_bike2 = 4
				ENDIF
			ENDIF	
		
			IF controlling_bike2 = 4
				IF off_bike2 = 1																	   
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 234.4 -1326.1 10.9
					SET_CAR_CRUISE_SPEED no2_bike 23.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 234.4 -1326.1 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE no2_bike 220.7 -1398.6 11.3
					controlling_bike2 = 5
				ENDIF
			ENDIF	

			IF controlling_bike2 = 5
				IF off_bike2 = 1																	   
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 220.7 -1398.6 10.9
					SET_CAR_CRUISE_SPEED no2_bike 23.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 220.7 -1398.6 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE no2_bike 169.0 -1525.2 11.3
					controlling_bike2 = 6
				ENDIF
			ENDIF	

			IF controlling_bike2 = 6
				IF off_bike2 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 169.0 -1525.2 10.9
					SET_CAR_CRUISE_SPEED no2_bike 23.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 169.0 -1525.2 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE no2_bike 192.8 -1583.0 11.3
					SET_CAR_CRUISE_SPEED no2_bike 15.0
					controlling_bike2 = 7
				ENDIF
			ENDIF	

			IF controlling_bike2 = 7
				IF off_bike2 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 192.8 -1583.0 10.9
					SET_CAR_CRUISE_SPEED no2_bike 23.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 192.8 -1583.0 7.0 7.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE no2_bike 240.5 -1689.2 11.3
					controlling_bike2 = 8
				ENDIF
			ENDIF	

			IF controlling_bike2 = 8
				IF off_bike2 = 1
					SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
					CAR_GOTO_COORDINATES no2_bike 240.5 -1689.2 10.9
					SET_CAR_CRUISE_SPEED no2_bike 15.0
					off_bike2 = 0
				ENDIF
				IF LOCATE_CAR_2D no2_bike 240.5 -1689.2 9.0 9.0 FALSE
					SET_CAR_TEMP_ACTION no2_bike TEMPACT_HANDBRAKESTRAIGHT 10000 
					SET_CAR_CRUISE_SPEED no2_bike 0.0
					SET_CAR_ONLY_DAMAGED_BY_PLAYER no2_bike FALSE
					controlling_bike2 = 9
				ENDIF
			ENDIF
			
			IF controlling_bike2 = 9
				SET_CHAR_OBJ_LEAVE_CAR shop_defend_guard2 no2_bike
				SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard2 258.7 -1703.0 
				timera = 0
				controlling_bike2 = 10   
			ENDIF

			IF controlling_bike2 > 9
				controlling_bike2 = 9
			ENDIF	
		ELSE
			IF controlling_bike2 < 9 
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 shop_defend_guard2 10.0 10.0 FALSE 
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS shop_defend_guard2 player1
				ELSE
					IF LOCATE_CHAR_ANY_MEANS_CAR_2D shop_defend_guard2 no2_bike 30.0 30.0 FALSE 
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER shop_defend_guard2 no2_bike
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS shop_defend_guard2 player1
					ENDIF 
				ENDIF
				off_bike2 = 1
			ELSE
			IF controlling_bike2 = 9
				IF IS_CHAR_IN_CAR shop_defend_guard2 no2_bike 
					SET_CHAR_OBJ_LEAVE_CAR shop_defend_guard2 no2_bike
				ENDIF
				SET_CHAR_OBJ_RUN_TO_COORD shop_defend_guard2 258.7 -1703.0 
				timera = 0
				controlling_bike2 = 10   
			ENDIF
				IF controlling_bike2 = 10
					IF NOT LOCATE_CHAR_ANY_MEANS_2D shop_defend_guard2 454.3 -1727.9 5.0 5.0 FALSE  
						IF timera > 500
							IF NOT IS_CHAR_WANDER_PATH_CLEAR shop_defend_guard2 454.3 -1727.9 9.0 1.0
								CHAR_FOLLOW_PATH shop_defend_guard2 454.3 -1727.9 9.0 1.0 RUN
							ENDIF
							timera = 0
						ENDIF
					ELSE
						SET_CHAR_OBJ_NO_OBJ shop_defend_guard2 
						SET_CHAR_STAY_IN_SAME_PLACE shop_defend_guard2 TRUE
						controlling_bike2 = 11
					ENDIF
				ENDIF
				IF controlling_bike2 = 11
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shop_defend_guard2 player1
					controlling_bike2 = 12
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CAR_AS_NO_LONGER_NEEDED no2_bike 
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS shop_defend_guard2 player1
	ENDIF
ELSE
	REMOVE_BLIP shop_defend_guard2_blip 
ENDIF 

IF IS_CHAR_DEAD shop_defend_guard1 
	IF IS_CHAR_DEAD shop_defend_guard2
		GOTO mission_passed_protec2
	ENDIF
ENDIF

GOTO chase_to_lighthouse 

// Mission failed
mission_failed_protec2:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_protec2:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 4000
REGISTER_MISSION_PASSED BUD_2
PLAYER_MADE_PROGRESS 1 
REMOVE_BLIP protect_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT -348.5 -541.8 16.4 RADAR_SPRITE_TOMMY protect_contact_blip
START_NEW_SCRIPT protect_mission3_loop
flag_protect_mission2_passed = 1
spaz_in_stock = 1
RETURN
		


// mission cleanup
mission_cleanup_protec2:
											    
flag_player_on_mission = 0
SET_PLAYER_CONTROL player1 on
CLEAR_ONSCREEN_TIMER dbp_time
MARK_MODEL_AS_NO_LONGER_NEEDED uzi
MARK_MODEL_AS_NO_LONGER_NEEDED brassknuckle
MARK_MODEL_AS_NO_LONGER_NEEDED m4
MARK_MODEL_AS_NO_LONGER_NEEDED pcj600
MARK_MODEL_AS_NO_LONGER_NEEDED GDa
MARK_MODEL_AS_NO_LONGER_NEEDED GDb
MARK_MODEL_AS_NO_LONGER_NEEDED HMOST
MARK_MODEL_AS_NO_LONGER_NEEDED oceanic
MARK_MODEL_AS_NO_LONGER_NEEDED sentinel
MARK_MODEL_AS_NO_LONGER_NEEDED securica
REMOVE_CHAR_ELEGANTLY prot_cuban1
REMOVE_CHAR_ELEGANTLY prot_cuban2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
REMOVE_BLIP shop_defend_guard1_blip
REMOVE_BLIP shop_defend_guard2_blip
REMOVE_BLIP shop_defend_guard3_blip
REMOVE_BLIP shop_defend_guard4_blip
REMOVE_BLIP shop_defend_guard5_blip
REMOVE_BLIP news_cafe_blip
DELETE_OBJECT fake_briefcase 
DELETE_OBJECT fake_briefcase1 
DELETE_OBJECT fake_briefcase2 
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}




			