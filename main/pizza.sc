MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Pizza Delivery Boy******************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME pizza 
// Mission start stuff
GOSUB mission_start_pizza
	IF HAS_DEATHARREST_BEEN_EXECUTED 
	 	GOSUB mission_failed_pizza
	ENDIF
GOSUB mission_cleanup_pizza					   
MISSION_END
// Variables for mission
//people, cars and objects
VAR_INT pizza_moped
VAR_INT customer1
VAR_INT customer2
VAR_INT customer3
VAR_INT customer4
VAR_INT customer5
VAR_INT customer6
VAR_INT customer7
VAR_INT customer8
VAR_INT customer9
VAR_INT customer10
VAR_INT pizza_box11
VAR_INT pizza_box2
VAR_INT pizza_box3
VAR_INT pizza_box4
VAR_INT pizza_box5
VAR_INT pizza_box6

//blips
VAR_INT customer1_blip
VAR_INT customer2_blip
VAR_INT customer3_blip
VAR_INT customer4_blip
VAR_INT customer5_blip
VAR_INT customer6_blip
VAR_INT customer7_blip
VAR_INT customer8_blip
VAR_INT customer9_blip
VAR_INT customer10_blip
VAR_INT pizza_hut_blip
VAR_INT pizza_moped_blip

//flags
VAR_INT pizza_goals
VAR_INT customers_created
VAR_INT customer1_created
VAR_INT customer2_created
VAR_INT customer3_created
VAR_INT customer4_created
VAR_INT customer5_created
VAR_INT customer6_created
VAR_INT customer7_created
VAR_INT customer8_created
VAR_INT customer9_created
VAR_INT customer10_created
VAR_INT pizza_delivered
VAR_INT go_back_to_pizza_hut_flag
VAR_INT total_pizzas_thrown
VAR_INT pizza_has_been_thrown
VAR_INT pizza_box_var
VAR_INT where_is_player1 
VAR_INT customer_complaint_time
VAR_INT customer_got_pizza 
VAR_INT customer_var
VAR_INT mission_failed_flag 
VAR_INT which_pizza_to_del 
VAR_INT flag_player_not_in_pizza_moped 
VAR_INT flag_pizza_moped_upsidedown
VAR_INT pizza_help_text_played 
VAR_INT add_pizza_score
VAR_INT random_speech
VAR_INT pizza_speech_played

//coordinates
VAR_FLOAT x_random
VAR_FLOAT y_random
VAR_FLOAT cust_coordx
VAR_FLOAT cust_coordy 
VAR_FLOAT cust_coordz
VAR_FLOAT sum_dif_xy
VAR_FLOAT dif_plyr_cust_x
VAR_FLOAT dif_plyr_cust_y
VAR_FLOAT player1s_distance_from_customer
VAR_FLOAT dif_cust_shop_x
VAR_FLOAT dif_cust_shop_y
VAR_FLOAT customers_distance_from_pizza_shop
VAR_FLOAT random_customer_heading
VAR_FLOAT pizza_shopx
VAR_FLOAT pizza_shopy
VAR_FLOAT pizza_shopz
VAR_FLOAT player1_facing_this_direction
VAR_FLOAT pizza_lobx
VAR_FLOAT pizza_loby
VAR_FLOAT pizzax
VAR_FLOAT pizzay
VAR_FLOAT pizzaz

// ****************************************Mission Start************************************
mission_start_pizza:

CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
WAIT 0
IF flag_pizza_mission_passed = 0
	REGISTER_MISSION_GIVEN
ENDIF

// stop path at the road 

LOAD_MISSION_TEXT PIZZA
// *****************************************Set Flags/variables************************************
pizza_goals = 1  //TEST, needs to be changed to 1 for final, 9 for end mission test
customers_created = 0
customer1_created = 0
customer2_created = 0
customer3_created = 0
customer4_created = 0
customer5_created = 0
customer6_created = 0
customer7_created = 0
customer8_created = 0
customer9_created = 0
customer10_created = 0
pizza_delivered = 0
go_back_to_pizza_hut_flag = 0
total_pizzas_thrown = 6
pizza_has_been_thrown = 0
pizza_box_var = 0
where_is_player1 = 0
customer_complaint_time = 301000 //5 mins
customer_got_pizza = 0
customer_var = 0
mission_failed_flag = 0  
which_pizza_to_del = 0
flag_player_not_in_pizza_moped = 0
flag_pizza_moped_upsidedown = 0
blob_flag = 0
pizza_help_text_played = 0
random_speech = 0
pizza_speech_played = 0

x_random = 0.0
y_random = 0.0
cust_coordx = 0.0 
cust_coordy = 0.0 
cust_coordz = 0.0
sum_dif_xy = 0.0
dif_plyr_cust_x = 0.0
dif_plyr_cust_y = 0.0
player1s_distance_from_customer = 0.0
dif_cust_shop_x = 0.0
dif_cust_shop_y = 0.0
customers_distance_from_pizza_shop = 0.0
random_customer_heading = 0.0
pizza_shopx = 0.0
pizza_shopy = 0.0
player1_facing_this_direction = 0.0
pizza_lobx = 0.0
pizza_loby = 0.0
pizzax = 0.0 
pizzay = 0.0 
pizzaz = 0.0 
player_x = 0.0
player_y = 0.0
player_z = 0.0
add_pizza_score = 0
{

// SCFIX: START
LVAR_INT pizza_audio_speech
LVAR_INT pizza_audio_state
pizza_audio_speech = 0
pizza_audio_state = 5
// SCFIX: END


//impossible if comment
GOTO pizza_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer1
	ADD_BLIP_FOR_CHAR customer1 customer1_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer2
	ADD_BLIP_FOR_CHAR customer2 customer2_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer3
	ADD_BLIP_FOR_CHAR customer3 customer3_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer4
	ADD_BLIP_FOR_CHAR customer4 customer4_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer5
	ADD_BLIP_FOR_CHAR customer5 customer5_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer6
	ADD_BLIP_FOR_CHAR customer6 customer6_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer7
	ADD_BLIP_FOR_CHAR customer7 customer7_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer8
	ADD_BLIP_FOR_CHAR customer8 customer8_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer9
	ADD_BLIP_FOR_CHAR customer9 customer9_blip
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer10
	ADD_BLIP_FOR_CHAR customer10 customer10_blip
	ADD_BLIP_FOR_COORD pizza_shopx pizza_shopy -100.0 pizza_hut_blip
pizza_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check

// *****************************************Start cutscene************************************
// *****************************************End cutscene**************************************
REQUEST_MODEL pizzabox

WHILE NOT HAS_MODEL_LOADED pizzabox 
	WAIT 0
ENDWHILE

SWITCH_CAR_GENERATOR gen_car6 0
SWITCH_CAR_GENERATOR gen_car4 0
SWITCH_CAR_GENERATOR gen_car2 0

SET_PLAYER_CAN_DO_DRIVE_BY player1 FALSE

IF IS_PLAYER_IN_ANY_CAR player1
	STORE_CAR_PLAYER_IS_IN player1 pizza_moped
ELSE
	PRINT_NOW ( PIZ1_32 ) 5000 1 //Pizza's too hot to handle?
	GOTO mission_failed_pizza
ENDIF 
	

GOTO pizza_fool_compiler2 // SCFIX: remove flag_player_on_mission = 0 check
	ADD_BLIP_FOR_CAR pizza_moped pizza_moped_blip
pizza_fool_compiler2: // SCFIX: remove flag_player_on_mission = 0 check

DISPLAY_ONSCREEN_TIMER customer_complaint_time TIMER_DOWN
DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_pizzas_thrown 0 PIZ1_12


//deciding where player1 is
IF IS_PLAYER_IN_ZONE player1 DTOWN
	where_is_player1 = 1
ENDIF
IF IS_PLAYER_IN_ZONE player1 HAITI
	where_is_player1 = 2
ENDIF
IF IS_PLAYER_IN_ZONE player1 BEACH3
	where_is_player1 = 3
ENDIF
/*
IF IS_PLAYER_IN_ZONE player1 BEACH1
	where_is_player1 = 4
ENDIF
*/
PRINT ( PIZ1_01 ) 7000 1 //Go deliver these pizzas, you must throw the pizza to the customers.  Do a drive-by to throw the pizzas.
PRINT ( PIZ1_05 ) 7000 1 //You have five minutes to deliver the orders before the customers phone another pizza shop.
timera = 0

start_pizza_mission: 
WAIT 0 

//printing initial help text
IF pizza_goals = 1 
	IF pizza_help_text_played = 0
		IF timera > 13999
			GET_CONTROLLER_MODE controlmode
			IF NOT controlmode = 3
				PRINT_HELP ( PIZ1_06 ) //Press the~h~ R3 button~w~ when on the bike to cancel the mission.
			ELSE
				PRINT_HELP ( PIZ1_0 )
			ENDIF
			pizza_help_text_played = 1
		ENDIF
	ENDIF
ENDIF

//reloading pizza's if player1 goes back to pizza shop
IF NOT IS_CAR_DEAD pizza_moped
	IF IS_PLAYER_IN_CAR player1 pizza_moped
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 pizza_shopx pizza_shopy pizza_shopz 3.0 3.0 3.0 FALSE
			IF timera > 14000
				IF total_pizzas_thrown > 0 
					CLEAR_PRINTS
					total_pizzas_thrown = 6
					GOSUB no_longer_needed_pizzas
					blob_flag = 0
					timera = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

//failing mission if time runs out

IF customer_complaint_time = 0
	PRINT_NOW ( PIZ1_08 ) 5000 1 //You are out of time.  You're fired.
	GOTO mission_failed_pizza
ENDIF


//creating right number of customers

WHILE customers_created < pizza_goals
	
	WAIT 0 

	GOSUB get_rnd_locations	
	GOSUB create_random_customer
	customers_created ++

	IF mission_failed_flag = 1
		PRINT_NOW ( PIZ1_07 ) 5000 1 //You killed the customer!  You're fired.
	ENDIF
	IF mission_failed_flag = 2
		PRINT_NOW ( PIZ1_09 ) 5000 1 //You destroyed our bike! You're fired.
	ENDIF
	IF mission_failed_flag = 3
		PRINT_NOW ( PIZ1_32 ) 5000 1 //Pizza's too hot to handle?
	ENDIF
	IF mission_failed_flag = 1
	OR mission_failed_flag = 2
	OR mission_failed_flag = 3  
		GOTO mission_failed_pizza
	ENDIF 
	GOSUB plyr_off_moped
	GOSUB plyr_quit_game
	GOSUB dying_customers
	GOSUB pizza_audio_process // SCFIX
ENDWHILE


//stoping mission or failing if customer dies
	IF mission_failed_flag = 1
		PRINT_NOW ( PIZ1_07 ) 5000 1 //You killed the customer!  You're fired.
	ENDIF
	IF mission_failed_flag = 2
		PRINT_NOW ( PIZ1_09 ) 5000 1 //You destroyed our bike! You're fired.
	ENDIF
	IF mission_failed_flag = 3
		PRINT_NOW ( PIZ1_32 ) 5000 1 //Pizza's too hot to handle?
	ENDIF
	IF mission_failed_flag = 1
	OR mission_failed_flag = 2
	OR mission_failed_flag = 3  
		GOTO mission_failed_pizza
	ENDIF 
	GOSUB plyr_off_moped
	GOSUB plyr_quit_game
	GOSUB dying_customers

//telling player1 to throw pizzas, (if he runs out to get more at pizza hut) then to get back to pizza hut for more customers once all are satisfied

IF go_back_to_pizza_hut_flag = 0
	IF pizza_delivered = pizza_goals
		// SCFIX: START - cosider mission passed as soon as the last pizza is delivered
		IF pizza_goals = 10 
		AND flag_pizza_mission_passed = 0
			GOTO mission_passed_pizza
		ENDIF
		// SCFIX: END
		IF flag_player_not_in_pizza_moped = 0
			PRINT_NOW ( PIZ1_33 ) 7000 1 //Return to the restaurant for more orders.
			REMOVE_BLIP pizza_hut_blip 
			ADD_BLIP_FOR_COORD pizza_shopx pizza_shopy pizza_shopz pizza_hut_blip  // SCFIX: z was -100.0
			go_back_to_pizza_hut_flag = 1
		ENDIF
	ELSE
		IF total_pizzas_thrown > 0
			GOSUB delivering_pizzas
		ELSE
			GOSUB delivering_pizzas
			IF blob_flag = 0
				PRINT_NOW ( PIZ1_02 ) 5000 1 //You have thrown all your pizzas, go back and get some more
				blob_flag = 1
			ENDIF
			REMOVE_BLIP customer1_blip
			REMOVE_BLIP customer2_blip
			REMOVE_BLIP customer3_blip
			REMOVE_BLIP customer4_blip
			REMOVE_BLIP customer5_blip
			REMOVE_BLIP customer6_blip
			REMOVE_BLIP customer7_blip
			REMOVE_BLIP customer8_blip
			REMOVE_BLIP customer9_blip
			REMOVE_BLIP customer10_blip
			REMOVE_BLIP pizza_hut_blip
			IF flag_player_not_in_pizza_moped = 0
				REMOVE_BLIP pizza_hut_blip 
				ADD_BLIP_FOR_COORD pizza_shopx pizza_shopy pizza_shopz pizza_hut_blip // SCFIX: z was -100.0

				IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 pizza_shopx pizza_shopy pizza_shopz 5.0 5.0 5.0 TRUE
					IF NOT IS_CHAR_DEAD customer1 
						ADD_BLIP_FOR_CHAR customer1 customer1_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer2 
						ADD_BLIP_FOR_CHAR customer2 customer2_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer3 
						ADD_BLIP_FOR_CHAR customer3 customer3_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer4 
						ADD_BLIP_FOR_CHAR customer4 customer4_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer5 
						ADD_BLIP_FOR_CHAR customer5 customer5_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer6 
						ADD_BLIP_FOR_CHAR customer6 customer6_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer7 
						ADD_BLIP_FOR_CHAR customer7 customer7_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer8 
						ADD_BLIP_FOR_CHAR customer8 customer8_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer9 
						ADD_BLIP_FOR_CHAR customer9 customer9_blip
					ENDIF
					IF NOT IS_CHAR_DEAD customer10 
						ADD_BLIP_FOR_CHAR customer10 customer10_blip
					ENDIF
			  		REMOVE_BLIP pizza_hut_blip
					pizza_speech_played = 0
					total_pizzas_thrown = 6
					GOSUB no_longer_needed_pizzas
					blob_flag = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 pizza_shopx pizza_shopy pizza_shopz 5.0 5.0 5.0 TRUE
		IF pizza_goals = 10 
			IF flag_pizza_mission_passed = 0
				GOTO mission_passed_pizza
			ELSE
				pizza_goals = 9
			ENDIF
		ELSE
			REMOVE_BLIP pizza_hut_blip
			customer_complaint_time = 301000 //5 mins
			pizza_speech_played = 0
			total_pizzas_thrown = 6
			GOSUB no_longer_needed_pizzas
			blob_flag = 0 
			customers_created = 0
			pizza_goals ++
			pizza_delivered = 0
			go_back_to_pizza_hut_flag = 0
		ENDIF
	ELSE
		IF total_pizzas_thrown > 0
			GOSUB delivering_pizzas
		ENDIF
	ENDIF
ENDIF   

GOSUB pizza_audio_process // SCFIX

GOTO start_pizza_mission 

// Mission failed
mission_failed_pizza:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_pizza:

CLEAR_PRINTS
CLEAR_WANTED_LEVEL player1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 5000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
ADD_SCORE player1 5000
IF flag_pizza_mission_passed = 0
	IF flag_baron_mission5_passed = 1 // SCFIX
		SWITCH_CAR_GENERATOR gen_car5 101
	ENDIF // SCFIX
	REGISTER_ODDJOB_MISSION_PASSED
	PRINT_NOW ( PIZ_WON ) 5000 1 //	Pizza Mission Complete.  
	PLAYER_MADE_PROGRESS 1
	//SET_PLAYER_NEVER_GETS_TIRED player1 TRUE
	INCREASE_PLAYER_MAX_HEALTH player1 50
	flag_pizza_mission_passed = 1
ENDIF
RETURN



// mission cleanup
mission_cleanup_pizza:
flag_player_on_mission = 0

SET_PLAYER_CONTROL player1 on
MARK_MODEL_AS_NO_LONGER_NEEDED faggio 
MARK_MODEL_AS_NO_LONGER_NEEDED pizzabox
SWITCH_CAR_GENERATOR gen_car6 101
SWITCH_CAR_GENERATOR gen_car4 101
SWITCH_CAR_GENERATOR gen_car2 101
ADD_PIZZAS_DELIVERED add_pizza_score
REMOVE_BLIP customer1_blip
REMOVE_BLIP customer2_blip
REMOVE_BLIP customer3_blip
REMOVE_BLIP customer4_blip
REMOVE_BLIP customer5_blip
REMOVE_BLIP customer6_blip
REMOVE_BLIP customer7_blip
REMOVE_BLIP customer8_blip
REMOVE_BLIP customer9_blip
REMOVE_BLIP customer10_blip
REMOVE_BLIP pizza_hut_blip
REMOVE_BLIP pizza_moped_blip
SET_PLAYER_CAN_DO_DRIVE_BY player1 TRUE
CLEAR_ONSCREEN_COUNTER total_pizzas_thrown
CLEAR_ONSCREEN_TIMER customer_complaint_time
flag_pizza_trigger = 1
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

//////////////////////////////////////////////////////////////////////
get_rnd_locations:////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
WAIT 0

GET_PLAYER_COORDINATES player1 player_x player_y player_z

//player1 is downtown
IF where_is_player1 = 1
	GENERATE_RANDOM_FLOAT_IN_RANGE -1050.4 -160.9 x_random
	GENERATE_RANDOM_FLOAT_IN_RANGE -160.0 1600.7 y_random
	pizza_shopx = -908.0 
	pizza_shopy = 809.3
	pizza_shopz = 10.5
ENDIF

//player1 is in Little Haiti
IF where_is_player1 = 2
	GENERATE_RANDOM_FLOAT_IN_RANGE -1200.4 -800.9 x_random
	GENERATE_RANDOM_FLOAT_IN_RANGE -660.0 300.7 y_random
	pizza_shopx = -1028.9 
	pizza_shopy = 82.7
	pizza_shopz = 10.7
ENDIF

//player1 is near Big Mall and Club
IF where_is_player1 = 3
	GENERATE_RANDOM_FLOAT_IN_RANGE -100.9 1000.4 x_random
	GENERATE_RANDOM_FLOAT_IN_RANGE -300.7 800.5 y_random
	pizza_shopx = 411.6
	pizza_shopy = 97.8
	pizza_shopz = 10.4
ENDIF

/*
//player1 is near Small mall
IF where_is_player1 = 4
	GENERATE_RANDOM_FLOAT_IN_RANGE -330.9 500.4 x_random
	GENERATE_RANDOM_FLOAT_IN_RANGE -1700.5 -730.7 y_random
	pizza_shopx = 115.3 
	pizza_shopy = -987.1
ENDIF
*/

GET_CLOSEST_CHAR_NODE x_random y_random player_z cust_coordx cust_coordy cust_coordz

//if char node is too high or too low
IF cust_coordz < 8.0
OR cust_coordz > 12.0
	GOTO get_rnd_locations
ENDIF 

//POLICE STATION BEACH SOUTH
IF cust_coordx > 333.358
AND cust_coordx < 435.544
AND cust_coordy	> -557.261
AND cust_coordy	< -433.179
	GOTO get_rnd_locations
ENDIF
//MALL BEACH SOUTH
IF cust_coordx >  -64.434
AND cust_coordx < 81.544
AND cust_coordy	> -995.198
AND cust_coordy	< -896.662
	GOTO get_rnd_locations
ENDIF
//MALIBU
IF cust_coordx >  446.491
AND cust_coordx < 599.769
AND cust_coordy	> -92.564
AND cust_coordy	< 53.415
	GOTO get_rnd_locations
ENDIF
//GOLF COURSE
IF cust_coordx >  -82.682
AND cust_coordx < 234.821
AND cust_coordy	> -272.607
AND cust_coordy	< 406.194
	GOTO get_rnd_locations
ENDIF
//GOLF COURSE
IF cust_coordx >  -290.702 
AND cust_coordx < 282.265
AND cust_coordy	> 398.714
AND cust_coordy	< 661.476
	GOTO get_rnd_locations
ENDIF
//BRIDGE
IF cust_coordx >  -728.193
AND cust_coordx < -67.639
AND cust_coordy	> -20.866
AND cust_coordy	< 99.566
	GOTO get_rnd_locations
ENDIF
//MANSION
IF cust_coordx >  -516.97
AND cust_coordx < -188.518
AND cust_coordy	> -667.97
AND cust_coordy	< -507.393
	GOTO get_rnd_locations
ENDIF
//TANKER
IF cust_coordx >  -710.393
AND cust_coordx < -579.012
AND cust_coordy	> -1416.112
AND cust_coordy	< -1211.742
	GOTO get_rnd_locations
ENDIF
//BIG MALL
IF cust_coordx >  333.358
AND cust_coordx < 493.934
AND cust_coordy	> 991.328
AND cust_coordy	< 1261.389
	GOTO get_rnd_locations
ENDIF
//BEHIND AMMUNATION DOWNTOWN
IF cust_coordx >  -790.682
AND cust_coordx < -626.456
AND cust_coordy	> 1196.908
AND cust_coordy	< 1306.392
	GOTO get_rnd_locations
ENDIF
//PHILS YARD
IF cust_coordx >  -1173.877
AND cust_coordx < -1027.898
AND cust_coordy	> 237.098
AND cust_coordy	< 415.922
	GOTO get_rnd_locations
ENDIF
//BUDDY YARD
IF cust_coordx >  -1389.195
AND cust_coordx < -1199.422
AND cust_coordy	> -47.561
AND cust_coordy	< 229.799
	GOTO get_rnd_locations
ENDIF
//AIPORT TEMINAL
IF cust_coordx >  -1571.667
AND cust_coordx < -1290.658
AND cust_coordy	> -1007.371
AND cust_coordy	< -784.753
	GOTO get_rnd_locations
ENDIF
// SCFIX: START
//SOUTH BRIDGE
IF cust_coordx >  -757.335
AND cust_coordx < -219.313
AND cust_coordy	> -979.568
AND cust_coordy	< -878.689
	GOTO get_rnd_locations
ENDIF
//STARISLAND BRIDGE
IF cust_coordx >  -180.88
AND cust_coordx < 64.112
AND cust_coordy	> -499.183
AND cust_coordy	< -417.519
	GOTO get_rnd_locations
ENDIF
//LIGHTHOUSE JETTYS
IF cust_coordx >  511.112
AND cust_coordx < 638.214
AND cust_coordy	> -1815.644
AND cust_coordy	< -1679.04
	GOTO get_rnd_locations
ENDIF
//BOAT YARD
IF cust_coordx >  -691.673
AND cust_coordx < -581.673
AND cust_coordy	> -1519.748
AND cust_coordy	< -1449.748
	GOTO get_rnd_locations
ENDIF
//PRINT WORKS
IF cust_coordx >  -1176.038
AND cust_coordx < -1012.796
AND cust_coordy	> -266.898
AND cust_coordy	< -158.26
	GOTO get_rnd_locations
ENDIF
//CAR YARD
IF cust_coordx >  -1031.494
AND cust_coordx < -949.479
AND cust_coordy	> -902.312
AND cust_coordy	< -821.592
	GOTO get_rnd_locations
ENDIF
//ICECREAM
IF cust_coordx >  -896.098
AND cust_coordx < -855.09
AND cust_coordy	> -593.101
AND cust_coordy	< -548.64
	GOTO get_rnd_locations
ENDIF
//TAXIFIRM
IF cust_coordx >  -1012.06
AND cust_coordx < -982.06
AND cust_coordy	> 181.561
AND cust_coordy	< 216.561
	GOTO get_rnd_locations
ENDIF
//PORN STUDIO
IF cust_coordx >  -112.495
AND cust_coordx < 9.705
AND cust_coordy	> 920.349
AND cust_coordy	< 1025.694
	GOTO get_rnd_locations
ENDIF
//HOTEL WITH GLASSHOUSE & SWIMMING POOL OUT BACK
IF cust_coordx >  533.891
AND cust_coordx < 673.891
AND cust_coordy	> -343.116
AND cust_coordy	< -183.116
	GOTO get_rnd_locations
ENDIF
//ARMY BASE
IF cust_coordx >  -1783.2216 
AND cust_coordx < -1586.5990 
AND cust_coordy	> -307.5092
AND cust_coordy	< -84.3105 
	GOTO get_rnd_locations
ENDIF
//PIZZA SHOP DOWNTOWN
IF cust_coordx >  -903.6972 
AND cust_coordx < -882.7946 
AND cust_coordy	> 791.7817
AND cust_coordy	< 808.3229
	GOTO get_rnd_locations
ENDIF
//PIZZA SHOP HAITI
IF cust_coordx >  -1059.2343 
AND cust_coordx < -1040.1482 
AND cust_coordy	> 73.3646 
AND cust_coordy	< 89.7497
	GOTO get_rnd_locations
ENDIF
//HAITIAN BASE
IF cust_coordx >  -1235.7916
AND cust_coordx < -1110.9315
AND cust_coordy	> 32.1217 
AND cust_coordy	< 126.1341
	GOTO get_rnd_locations
ENDIF
//G-SPOTLIGHT OFFICE
IF cust_coordx >  -570.1256
AND cust_coordx < -453.1256
AND cust_coordy	> 888.7261 
AND cust_coordy	< 1018.3261
	GOTO get_rnd_locations
ENDIF
// SCFIX: END

//if player1s too close to customers

dif_plyr_cust_x = player_x - cust_coordx
dif_plyr_cust_y = player_y - cust_coordy
dif_plyr_cust_x = dif_plyr_cust_x * dif_plyr_cust_x
dif_plyr_cust_y = dif_plyr_cust_y * dif_plyr_cust_y
sum_dif_xy = dif_plyr_cust_x + dif_plyr_cust_y
SQRT sum_dif_xy player1s_distance_from_customer

IF player1s_distance_from_customer < 120.0
	GOTO get_rnd_locations
ENDIF

//if customers to close to pizza shop

dif_cust_shop_x = pizza_shopx - cust_coordx
dif_cust_shop_y = pizza_shopy - cust_coordy
dif_cust_shop_x = dif_cust_shop_x * dif_cust_shop_x
dif_cust_shop_y = dif_cust_shop_y * dif_cust_shop_y
sum_dif_xy = dif_cust_shop_x + dif_cust_shop_y
SQRT sum_dif_xy customers_distance_from_pizza_shop

IF customers_distance_from_pizza_shop < 100.0
	GOTO get_rnd_locations
ENDIF

//if cust is too near to other custs


IF customer1_created = 1
	IF NOT IS_CHAR_DEAD customer1
		IF LOCATE_CHAR_ANY_MEANS_2D customer1 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer2_created = 1
	IF NOT IS_CHAR_DEAD customer2
		IF LOCATE_CHAR_ANY_MEANS_2D customer2 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer3_created = 1
	IF NOT IS_CHAR_DEAD customer3
		IF LOCATE_CHAR_ANY_MEANS_2D customer3 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer4_created = 1
	IF NOT IS_CHAR_DEAD customer4
		IF LOCATE_CHAR_ANY_MEANS_2D customer4 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer5_created = 1
	IF NOT IS_CHAR_DEAD customer5
		IF LOCATE_CHAR_ANY_MEANS_2D customer5 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer6_created = 1
	IF NOT IS_CHAR_DEAD customer6
		IF LOCATE_CHAR_ANY_MEANS_2D customer6 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer7_created = 1
	IF NOT IS_CHAR_DEAD customer7
		IF LOCATE_CHAR_ANY_MEANS_2D customer7 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer8_created = 1
	IF NOT IS_CHAR_DEAD customer8
		IF LOCATE_CHAR_ANY_MEANS_2D customer8 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer9_created = 1
	IF NOT IS_CHAR_DEAD customer9
		IF LOCATE_CHAR_ANY_MEANS_2D customer9 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF

IF customer10_created = 1
	IF NOT IS_CHAR_DEAD customer10
		IF LOCATE_CHAR_ANY_MEANS_2D customer10 cust_coordx cust_coordy 25.0 25.0 0
			GOTO get_rnd_locations
		ENDIF
	ENDIF
ENDIF
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
create_random_customer:///////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
IF pizza_goals > 0
AND customer1_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer1 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer1 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer1
	SET_CHAR_OBJ_WAIT_ON_FOOT customer1
	ADD_BLIP_FOR_CHAR customer1 customer1_blip
	customer1_created = 1
	RETURN
ENDIF   

IF pizza_goals > 1
AND customer2_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer2 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer2 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer2
	SET_CHAR_OBJ_WAIT_ON_FOOT customer2
	ADD_BLIP_FOR_CHAR customer2 customer2_blip
	customer2_created = 1
	RETURN
ENDIF   


IF pizza_goals > 2
AND customer3_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer3 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer3 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer3
	SET_CHAR_OBJ_WAIT_ON_FOOT customer3
	ADD_BLIP_FOR_CHAR customer3 customer3_blip
	customer3_created = 1
	RETURN
ENDIF   


IF pizza_goals > 3
AND customer4_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer4 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer4 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer4
	SET_CHAR_OBJ_WAIT_ON_FOOT customer4
	ADD_BLIP_FOR_CHAR customer4 customer4_blip
	customer4_created = 1
	RETURN
ENDIF   


IF pizza_goals > 4
AND customer5_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer5 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer5 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer5
	SET_CHAR_OBJ_WAIT_ON_FOOT customer5
	ADD_BLIP_FOR_CHAR customer5 customer5_blip
	customer5_created = 1
	RETURN
ENDIF   


IF pizza_goals > 5
AND customer6_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer6 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer6 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer6
	SET_CHAR_OBJ_WAIT_ON_FOOT customer6
	ADD_BLIP_FOR_CHAR customer6 customer6_blip
	customer6_created = 1
	RETURN
ENDIF   


IF pizza_goals > 6
AND customer7_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer7 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer7 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer7
	SET_CHAR_OBJ_WAIT_ON_FOOT customer7
	ADD_BLIP_FOR_CHAR customer7 customer7_blip
	customer7_created = 1
	RETURN
ENDIF   


IF pizza_goals > 7
AND customer8_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer8 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer8 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer8
	SET_CHAR_OBJ_WAIT_ON_FOOT customer8
	ADD_BLIP_FOR_CHAR customer8 customer8_blip
	customer8_created = 1
	RETURN
ENDIF   


IF pizza_goals > 8
AND customer9_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer9 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer9 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer9
	SET_CHAR_OBJ_WAIT_ON_FOOT customer9
	ADD_BLIP_FOR_CHAR customer9 customer9_blip
	customer9_created = 1
	RETURN
ENDIF   


IF pizza_goals > 9
AND customer10_created = 0	
	CREATE_RANDOM_CHAR cust_coordx cust_coordy cust_coordz customer10 
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_customer_heading
	SET_CHAR_HEADING customer10 random_customer_heading
	CLEAR_CHAR_THREAT_SEARCH customer10
	SET_CHAR_OBJ_WAIT_ON_FOOT customer10
	ADD_BLIP_FOR_CHAR customer10 customer10_blip
	customer10_created = 1
	RETURN
ENDIF   
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
pizza_throw_right:////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
IF pizza_has_been_thrown = 0 
	CREATE_OBJECT_NO_OFFSET pizzabox 0.0 0.0 100.0 pizza_box_var   
	PLACE_OBJECT_RELATIVE_TO_CAR pizza_box_var pizza_moped 0.7 0.0 0.7
  	SET_OBJECT_COLLISION pizza_box_var TRUE 	  
  	SET_OBJECT_DYNAMIC pizza_box_var TRUE
  	GET_PLAYER_HEADING player1 player1_facing_this_direction 
  	pizza_lobx -= 90.0
	pizza_loby -= 90.0
  	COS player1_facing_this_direction pizza_lobx  
  	SIN player1_facing_this_direction pizza_loby 
  	pizza_lobx *= 12.0 	 //change this to increase power of toss
	pizza_loby *= 12.0	 
  	ADD_TO_OBJECT_VELOCITY pizza_box_var pizza_lobx pizza_loby 5.0
	total_pizzas_thrown --
	pizza_has_been_thrown = 1
ENDIF
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
pizza_throw_left://///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
IF pizza_has_been_thrown = 0 
	CREATE_OBJECT_NO_OFFSET pizzabox 0.0 0.0 100.0 pizza_box_var   
	PLACE_OBJECT_RELATIVE_TO_CAR pizza_box_var pizza_moped -0.7 0.0 0.7
  	SET_OBJECT_COLLISION pizza_box_var TRUE 	  
  	SET_OBJECT_DYNAMIC pizza_box_var TRUE
  	GET_PLAYER_HEADING player1 player1_facing_this_direction 
  	pizza_lobx -= 90.0
	pizza_loby -= 90.0
  	COS player1_facing_this_direction pizza_lobx  
  	SIN player1_facing_this_direction pizza_loby 
  	pizza_lobx *= -12.0
	pizza_loby *= -12.0
  	ADD_TO_OBJECT_VELOCITY pizza_box_var pizza_lobx pizza_loby 5.0
	total_pizzas_thrown --
	pizza_has_been_thrown = 1
ENDIF
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
delivering_pizzas:////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
IF NOT IS_CAR_DEAD pizza_moped
	IF IS_PLAYER_IN_CAR player1 pizza_moped
		
//firing pizza right
		GET_CONTROLLER_MODE controlmode
		IF NOT controlmode = 3
			IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2 
				IF IS_BUTTON_PRESSED PAD1 CIRCLE 
					IF total_pizzas_thrown = 6 
						GOSUB pizza_throw_right 
						pizza_box11 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 5 
						GOSUB pizza_throw_right  
						pizza_box2 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 4 
						GOSUB pizza_throw_right  
						pizza_box3 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 3 
						GOSUB pizza_throw_right  
						pizza_box4 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 2 
						GOSUB pizza_throw_right  
						pizza_box5 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 1 
						GOSUB pizza_throw_right  
						pizza_box6 = pizza_box_var
					ENDIF	
				ELSE
					pizza_has_been_thrown = 0
				ENDIF
			ENDIF
		ELSE
			IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2 
				IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER1 
					IF total_pizzas_thrown = 6 
						GOSUB pizza_throw_right 
						pizza_box11 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 5 
						GOSUB pizza_throw_right  
						pizza_box2 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 4 
						GOSUB pizza_throw_right  
						pizza_box3 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 3 
						GOSUB pizza_throw_right  
						pizza_box4 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 2 
						GOSUB pizza_throw_right  
						pizza_box5 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 1 
						GOSUB pizza_throw_right  
						pizza_box6 = pizza_box_var
					ENDIF	
				ELSE
					pizza_has_been_thrown = 0
				ENDIF
			ENDIF
		ENDIF
							   
//firing pizza left
		IF NOT controlmode = 3
			IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2 
				IF IS_BUTTON_PRESSED PAD1 CIRCLE
					IF total_pizzas_thrown = 6 
						GOSUB pizza_throw_left
						pizza_box11 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 5 
						GOSUB pizza_throw_left  
						pizza_box2 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 4 
						GOSUB pizza_throw_left  
						pizza_box3 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 3 
						GOSUB pizza_throw_left  
						pizza_box4 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 2 
						GOSUB pizza_throw_left  
						pizza_box5 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 1 
						GOSUB pizza_throw_left  
						pizza_box6 = pizza_box_var
					ENDIF		
				ELSE
					pizza_has_been_thrown = 0   
				ENDIF
			ENDIF
		ELSE
			IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2 
				IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER1
					IF total_pizzas_thrown = 6 
						GOSUB pizza_throw_left
						pizza_box11 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 5 
						GOSUB pizza_throw_left  
						pizza_box2 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 4 
						GOSUB pizza_throw_left  
						pizza_box3 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 3 
						GOSUB pizza_throw_left  
						pizza_box4 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 2 
						GOSUB pizza_throw_left  
						pizza_box5 = pizza_box_var
					ENDIF		   
					IF total_pizzas_thrown = 1 
						GOSUB pizza_throw_left  
						pizza_box6 = pizza_box_var
					ENDIF		
				ELSE
					pizza_has_been_thrown = 0   
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

//if pizza is in range of customer

IF customer1_created = 1
	IF NOT IS_CHAR_DEAD customer1
		customer_var = customer1
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer1
				SET_CHAR_WAIT_STATE customer1 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500 
			GOSUB del_pizzas
			MARK_CHAR_AS_NO_LONGER_NEEDED customer1 
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer1_blip
			customer1_created = 0
			pizza_delivered ++
			add_pizza_score ++



			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer2_created = 1
	IF NOT IS_CHAR_DEAD customer2
		customer_var = customer2
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer2
				SET_CHAR_WAIT_STATE customer2 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer2
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer2_blip
			customer2_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer3_created = 1
	IF NOT IS_CHAR_DEAD customer3
		customer_var = customer3
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer3
				SET_CHAR_WAIT_STATE customer3 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer3
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer3_blip
			customer3_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer4_created = 1
	IF NOT IS_CHAR_DEAD customer4
		customer_var = customer4
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer4
				SET_CHAR_WAIT_STATE customer4 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer4
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer4_blip
			customer4_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer5_created = 1
	IF NOT IS_CHAR_DEAD customer5
		customer_var = customer5
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1
			IF NOT IS_CHAR_DEAD customer5
				SET_CHAR_WAIT_STATE customer5 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer5
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer5_blip
			customer5_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer6_created = 1
	IF NOT IS_CHAR_DEAD customer6
		customer_var = customer6
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer6
				SET_CHAR_WAIT_STATE customer6 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer6
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer6_blip
			customer6_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer7_created = 1
	IF NOT IS_CHAR_DEAD customer7
		customer_var = customer7
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer7
				SET_CHAR_WAIT_STATE customer7 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer7
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer7_blip
			customer7_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer8_created = 1
	IF NOT IS_CHAR_DEAD customer8
		customer_var = customer8
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer8
				SET_CHAR_WAIT_STATE customer8 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer8
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer8_blip
			customer8_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer9_created = 1
	IF NOT IS_CHAR_DEAD customer9
		customer_var = customer9
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer9
				SET_CHAR_WAIT_STATE customer9 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer9
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer9_blip
			customer9_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF

IF customer10_created = 1
	IF NOT IS_CHAR_DEAD customer10
		customer_var = customer10
		GOSUB catch_da_pizza  
		IF customer_got_pizza = 1 
			IF NOT IS_CHAR_DEAD customer10
				SET_CHAR_WAIT_STATE customer10 WAITSTATE_PLAYANIM_DUCK 500
			ELSE
				mission_failed_flag = 1	
			ENDIF	
			WAIT 500    
			GOSUB del_pizzas   
			MARK_CHAR_AS_NO_LONGER_NEEDED customer10
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE  
			PRINT_NOW ( PIZ1_34 ) 5000 1 //Pizza delivered, here's your cash.
			ADD_SCORE player1 10
			REMOVE_BLIP customer10_blip
			customer10_created = 0
			pizza_delivered ++
			add_pizza_score ++
			customer_got_pizza = 0
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF
GOSUB plyr_off_moped
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
catch_da_pizza:///////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
IF DOES_OBJECT_EXIST pizza_box11 
	IF NOT IS_CHAR_DEAD customer_var 
		IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box11 2.0 2.0 FALSE
			which_pizza_to_del = 1
			WAIT 20
			timerb = 0
			box1a:
				WAIT 0
				IF timerb > 3000
					GOTO box1b
				ENDIF
				IF NOT IS_CHAR_DEAD customer_var 
					IF DOES_OBJECT_EXIST pizza_box11 
						GET_OBJECT_COORDINATES pizza_box11 pizzax pizzay pizzaz
						SET_CHAR_OBJ_RUN_TO_COORD customer_var pizzax pizzay 
						IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box11 2.0 2.0 FALSE
							GOTO box1b
						ENDIF
					ENDIF
				ELSE
					mission_failed_flag = 1
				ENDIF
				GOSUB plyr_off_moped
				GOSUB plyr_quit_game 
			GOTO box1a
			box1b: 
			customer_got_pizza = 1
		ENDIF
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF
IF DOES_OBJECT_EXIST pizza_box2 
	IF NOT IS_CHAR_DEAD customer_var 
		IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box2 2.0 2.0 FALSE
			which_pizza_to_del = 2
			WAIT 20
			timerb = 0
			box2a:
				WAIT 0
				IF timerb > 3000
					GOTO box2b
				ENDIF
				IF NOT IS_CHAR_DEAD customer_var 
					IF DOES_OBJECT_EXIST pizza_box2 
						GET_OBJECT_COORDINATES pizza_box2 pizzax pizzay pizzaz
						SET_CHAR_OBJ_RUN_TO_COORD customer_var pizzax pizzay 
						IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box2 2.0 2.0 FALSE
							GOTO box2b
						ENDIF
					ENDIF
				ELSE
					mission_failed_flag = 1
				ENDIF
				GOSUB plyr_off_moped
				GOSUB plyr_quit_game 
			GOTO box2a
			box2b: 
			customer_got_pizza = 1
		ENDIF	
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF
IF DOES_OBJECT_EXIST pizza_box3 
	IF NOT IS_CHAR_DEAD customer_var 
		IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box3 2.0 2.0 FALSE
			which_pizza_to_del = 3
			WAIT 20
			timerb = 0
			box3a:
				WAIT 0
				IF timerb > 3000
					GOTO box3b
				ENDIF
				IF NOT IS_CHAR_DEAD customer_var 
					IF DOES_OBJECT_EXIST pizza_box3 
						GET_OBJECT_COORDINATES pizza_box3 pizzax pizzay pizzaz
						SET_CHAR_OBJ_RUN_TO_COORD customer_var pizzax pizzay 
						IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box3 2.0 2.0 FALSE
							GOTO box3b
						ENDIF
					ENDIF
				ELSE
					mission_failed_flag = 1
				ENDIF
				GOSUB plyr_off_moped
				GOSUB plyr_quit_game 
			GOTO box3a
			box3b: 
			customer_got_pizza = 1
	  	ENDIF	
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF
IF DOES_OBJECT_EXIST pizza_box4 
	IF NOT IS_CHAR_DEAD customer_var 
		IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box4 2.0 2.0 FALSE
			which_pizza_to_del = 4
			WAIT 20
			timerb = 0
			box4a:
				WAIT 0
				IF timerb > 3000
					GOTO box4b
				ENDIF
				IF NOT IS_CHAR_DEAD customer_var 
					IF DOES_OBJECT_EXIST pizza_box4 
						GET_OBJECT_COORDINATES pizza_box4 pizzax pizzay pizzaz
						SET_CHAR_OBJ_RUN_TO_COORD customer_var pizzax pizzay 
						IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box4 2.0 2.0 FALSE
							GOTO box4b
						ENDIF
					ENDIF
				ELSE
					mission_failed_flag = 1
				ENDIF
				GOSUB plyr_off_moped
				GOSUB plyr_quit_game 
			GOTO box4a
			box4b: 
			customer_got_pizza = 1
		ENDIF	
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF
IF DOES_OBJECT_EXIST pizza_box5 
	IF NOT IS_CHAR_DEAD customer_var 
		IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box5 2.0 2.0 FALSE
			which_pizza_to_del = 5
			WAIT 20
			timerb = 0
			box5a:
				WAIT 0
				IF timerb > 3000
					GOTO box5b
				ENDIF
				IF NOT IS_CHAR_DEAD customer_var 
					IF DOES_OBJECT_EXIST pizza_box5 
						GET_OBJECT_COORDINATES pizza_box5 pizzax pizzay pizzaz
						SET_CHAR_OBJ_RUN_TO_COORD customer_var pizzax pizzay 
						IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box5 2.0 2.0 FALSE
							GOTO box5b
						ENDIF
					ENDIF
				ELSE
					mission_failed_flag = 1
				ENDIF
				GOSUB plyr_off_moped
				GOSUB plyr_quit_game 
			GOTO box5a
			box5b: 
			customer_got_pizza = 1
		ENDIF	
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF
IF DOES_OBJECT_EXIST pizza_box6 
	IF NOT IS_CHAR_DEAD customer_var 
		IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box6 2.0 2.0 FALSE
			which_pizza_to_del = 6
			WAIT 20
			timerb = 0
			box6a:
				WAIT 0
				IF timerb > 3000
					GOTO box6b
				ENDIF
				IF NOT IS_CHAR_DEAD customer_var 
					IF DOES_OBJECT_EXIST pizza_box6 
						GET_OBJECT_COORDINATES pizza_box6 pizzax pizzay pizzaz
						SET_CHAR_OBJ_RUN_TO_COORD customer_var pizzax pizzay 
						IF LOCATE_CHAR_ON_FOOT_OBJECT_2D customer_var pizza_box6 2.0 2.0 FALSE
							GOTO box6b
						ENDIF
					ENDIF
				ELSE
					mission_failed_flag = 1
				ENDIF
				GOSUB plyr_off_moped
				GOSUB plyr_quit_game 
			GOTO box6a
			box6b: 
			customer_got_pizza = 1
		ENDIF	
	ELSE
		mission_failed_flag = 1	
	ENDIF	
ENDIF
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
del_pizzas:///////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
IF which_pizza_to_del = 1
	DELETE_OBJECT pizza_box11
ENDIF
IF which_pizza_to_del = 2
	DELETE_OBJECT pizza_box2
ENDIF 
IF which_pizza_to_del = 3
	DELETE_OBJECT pizza_box3
ENDIF 
IF which_pizza_to_del = 4
	DELETE_OBJECT pizza_box4
ENDIF 
IF which_pizza_to_del = 5
	DELETE_OBJECT pizza_box5
ENDIF 
IF which_pizza_to_del = 6
	DELETE_OBJECT pizza_box6
ENDIF 					   
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
no_longer_needed_pizzas://////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
MARK_OBJECT_AS_NO_LONGER_NEEDED pizza_box11
MARK_OBJECT_AS_NO_LONGER_NEEDED pizza_box2
MARK_OBJECT_AS_NO_LONGER_NEEDED pizza_box3
MARK_OBJECT_AS_NO_LONGER_NEEDED pizza_box4
MARK_OBJECT_AS_NO_LONGER_NEEDED pizza_box5
MARK_OBJECT_AS_NO_LONGER_NEEDED pizza_box6


GENERATE_RANDOM_INT_IN_RANGE 1 20 random_speech

IF pizza_speech_played = 0
	/* SCFIX: removed
	IF random_speech = 1 
		LOAD_MISSION_AUDIO 1 PISS_01
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_13 4000 1//Get these delivered nice and hot.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_13 
	ENDIF
	IF random_speech = 2 
		LOAD_MISSION_AUDIO 1 PISS_02
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_14 4000 1//Pal, pizza's for you.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_14 
	ENDIF
	IF random_speech = 3 
		LOAD_MISSION_AUDIO 1 PISS_03
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_15 4000 1//Hey, come on Mister, deliver these quick.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_15 
	ENDIF
	IF random_speech = 4 
		LOAD_MISSION_AUDIO 1 PISS_04
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_16 4000 1//What are you waiting around for Mister?  You got pizza's to deliver.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_16 
	ENDIF
	IF random_speech = 5 
		LOAD_MISSION_AUDIO 1 PISS_05
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_17 4000 1//I know you didn't want to be a pizza boy, well I don't give a damn.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_17 
	ENDIF
	IF random_speech = 6 
		LOAD_MISSION_AUDIO 1 PISS_06
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_18 4000 1//Deliver these.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_18 
	ENDIF
	IF random_speech = 7 
		LOAD_MISSION_AUDIO 1 PISS_07
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_19 4000 1//These need delivering.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_19
	ENDIF
	IF random_speech = 8 
		LOAD_MISSION_AUDIO 1 PISS_08
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_20 4000 1//Come on Mister, deliver these things or you're sacked.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_20 
	ENDIF
	IF random_speech = 9 
		LOAD_MISSION_AUDIO 1 PISS_09
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_21 4000 1//We got people waiting pal.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_21 
	ENDIF
	IF random_speech = 10 
		LOAD_MISSION_AUDIO 1 PISS_10
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_22 4000 1//What are you waiting around for?  These need delivering!
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_22 
	ENDIF
	IF random_speech = 11 
		LOAD_MISSION_AUDIO 1 PISS_11
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_23 4000 1//Deliver the damn food Mister.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_23 
	ENDIF
	IF random_speech = 12 
		LOAD_MISSION_AUDIO 1 PISS_12
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_24 4000 1//These need delivering pal.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_24 
	ENDIF
	IF random_speech = 13 
		LOAD_MISSION_AUDIO 1 PISS_13
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_25 4000 1//Man, can you take these?
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_25 
	ENDIF
	IF random_speech = 14 
		LOAD_MISSION_AUDIO 1 PISS_14
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_26 4000 1//Mister, deliver these pronto, avamos amigo.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_26 
	ENDIF
	IF random_speech = 15 
		LOAD_MISSION_AUDIO 1 PISS_15
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_27 4000 1//Come on, we're in a rush, deliver these.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_27 
	ENDIF
	IF random_speech = 16 
		LOAD_MISSION_AUDIO 1 PISS_16
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_28 4000 1//You again?  well deliver these quick pal.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_28 
	ENDIF
	IF random_speech = 17 
		LOAD_MISSION_AUDIO 1 PISS_17
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_29 4000 1//No wasting time this time pal.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_29 
	ENDIF
	IF random_speech = 18 
		LOAD_MISSION_AUDIO 1 PISS_18
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_30 4000 1//Come on you lazy bastard, deliver this crap on time.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_30 
	ENDIF
	IF random_speech = 19 
		LOAD_MISSION_AUDIO 1 PISS_19
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW PIZ1_31 4000 1//You'll never get a promotion unless you move faster this time.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT PIZ1_31 
	ENDIF
	*/
	// SCFIX: START
	pizza_speech_played = 1
	GOSUB pizza_audio_clear
	pizza_audio_speech = random_speech
	pizza_audio_state = 0
	// SCFIX: END
ENDIF
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
dying_customers://////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
IF customer1_created = 1
	IF IS_CHAR_DEAD customer1
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer2_created = 1
	IF IS_CHAR_DEAD customer2
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer3_created = 1
	IF IS_CHAR_DEAD customer3
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer4_created = 1
	IF IS_CHAR_DEAD customer4
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer5_created = 1
	IF IS_CHAR_DEAD customer5
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer6_created = 1
	IF IS_CHAR_DEAD customer6
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer7_created = 1
	IF IS_CHAR_DEAD customer7
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer8_created = 1
	IF IS_CHAR_DEAD customer8
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer9_created = 1
	IF IS_CHAR_DEAD customer9
		mission_failed_flag = 1
	ENDIF
ENDIF 
IF customer10_created = 1
	IF IS_CHAR_DEAD customer10
		mission_failed_flag = 1
	ENDIF
ENDIF 
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
plyr_off_moped:///////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
IF NOT IS_CAR_DEAD pizza_moped 
	IF IS_CAR_UPSIDEDOWN pizza_moped
	AND IS_CAR_STOPPED pizza_moped
		flag_pizza_moped_upsidedown = 1
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player1 pizza_moped
	AND flag_player_not_in_pizza_moped = 0
	AND flag_pizza_moped_upsidedown = 0
		PRINT_NOW ( PIZ1_11 ) 5000 1 //Hey! Get back on the bike!
		ADD_BLIP_FOR_CAR pizza_moped pizza_moped_blip
		REMOVE_BLIP customer1_blip
		REMOVE_BLIP customer2_blip
		REMOVE_BLIP customer3_blip
		REMOVE_BLIP customer4_blip
		REMOVE_BLIP customer5_blip
		REMOVE_BLIP customer6_blip
		REMOVE_BLIP customer7_blip
		REMOVE_BLIP customer8_blip
		REMOVE_BLIP customer9_blip
		REMOVE_BLIP customer10_blip
		REMOVE_BLIP pizza_hut_blip
		flag_player_not_in_pizza_moped = 1 
	ENDIF

	IF IS_PLAYER_IN_CAR player1 pizza_moped
	AND flag_player_not_in_pizza_moped = 1
		REMOVE_BLIP pizza_moped_blip
		IF go_back_to_pizza_hut_flag = 0
			IF customer1_created = 1
				IF NOT IS_CHAR_DEAD customer1 
					ADD_BLIP_FOR_CHAR customer1 customer1_blip
				ENDIF
			ENDIF
			IF customer2_created = 1
				IF NOT IS_CHAR_DEAD customer2 
					ADD_BLIP_FOR_CHAR customer2 customer2_blip
				ENDIF
			ENDIF
			IF customer3_created = 1
				IF NOT IS_CHAR_DEAD customer3 
					ADD_BLIP_FOR_CHAR customer3 customer3_blip
				ENDIF
			ENDIF
			IF customer4_created = 1
				IF NOT IS_CHAR_DEAD customer4 
					ADD_BLIP_FOR_CHAR customer4 customer4_blip
				ENDIF
			ENDIF
			IF customer5_created = 1
				IF NOT IS_CHAR_DEAD customer5 
					ADD_BLIP_FOR_CHAR customer5 customer5_blip
				ENDIF
			ENDIF
			IF customer6_created = 1
				IF NOT IS_CHAR_DEAD customer6 
					ADD_BLIP_FOR_CHAR customer6 customer6_blip
				ENDIF
			ENDIF
			IF customer7_created = 1
				IF NOT IS_CHAR_DEAD customer7 
					ADD_BLIP_FOR_CHAR customer7 customer7_blip
				ENDIF
			ENDIF
			IF customer8_created = 1
				IF NOT IS_CHAR_DEAD customer8 
					ADD_BLIP_FOR_CHAR customer8 customer8_blip
				ENDIF
			ENDIF
			IF customer9_created = 1
				IF NOT IS_CHAR_DEAD customer9 
					ADD_BLIP_FOR_CHAR customer9 customer9_blip
				ENDIF
			ENDIF
			IF customer10_created = 1
				IF NOT IS_CHAR_DEAD customer10 
					ADD_BLIP_FOR_CHAR customer10 customer10_blip
				ENDIF
			ENDIF
		ELSE
			REMOVE_BLIP pizza_hut_blip 
			ADD_BLIP_FOR_COORD pizza_shopx pizza_shopy pizza_shopz pizza_hut_blip // SCFIX: z was -100.0
		ENDIF
		CLEAR_PRINTS
		flag_player_not_in_pizza_moped = 0
	ENDIF
ELSE
	mission_failed_flag = 2
ENDIF	
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
plyr_quit_game:///////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

IF flag_player_not_in_pizza_moped = 0
	GET_CONTROLLER_MODE controlmode
	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			CLEAR_PRINTS 
			mission_failed_flag = 3
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
			CLEAR_PRINTS 
			mission_failed_flag = 3
		ENDIF
	ENDIF
ENDIF
//////////////////////////////////////////////////////////////////////
RETURN////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

// SCFIX: START
pizza_audio_process:
IF pizza_audio_state = 0
	GOSUB pizza_audio_load
	pizza_audio_state ++
ENDIF
IF pizza_audio_state = 1
	IF HAS_MISSION_AUDIO_LOADED 1
		pizza_audio_state ++
	ENDIF
	RETURN
ENDIF
IF pizza_audio_state = 2
	GOSUB pizza_audio_print
	PLAY_MISSION_AUDIO 1
	pizza_audio_state ++
ENDIF
IF pizza_audio_state = 3
	IF HAS_MISSION_AUDIO_FINISHED 1
		pizza_audio_state ++
	ENDIF
	RETURN
ENDIF
IF pizza_audio_state = 4
	GOSUB pizza_audio_clear
	pizza_audio_state ++
ENDIF
RETURN

pizza_audio_load:
IF pizza_audio_speech = 1
	LOAD_MISSION_AUDIO 1 PISS_01
	RETURN
ENDIF
IF pizza_audio_speech = 2
	LOAD_MISSION_AUDIO 1 PISS_02
	RETURN
ENDIF
IF pizza_audio_speech = 3
	LOAD_MISSION_AUDIO 1 PISS_03
	RETURN
ENDIF
IF pizza_audio_speech = 4
	LOAD_MISSION_AUDIO 1 PISS_04
	RETURN
ENDIF
IF pizza_audio_speech = 5
	LOAD_MISSION_AUDIO 1 PISS_05
	RETURN
ENDIF
IF pizza_audio_speech = 6
	LOAD_MISSION_AUDIO 1 PISS_06
	RETURN
ENDIF
IF pizza_audio_speech = 7
	LOAD_MISSION_AUDIO 1 PISS_07
	RETURN
ENDIF
IF pizza_audio_speech = 8
	LOAD_MISSION_AUDIO 1 PISS_08
	RETURN
ENDIF
IF pizza_audio_speech = 9
	LOAD_MISSION_AUDIO 1 PISS_09
	RETURN
ENDIF
IF pizza_audio_speech = 10
	LOAD_MISSION_AUDIO 1 PISS_10
	RETURN
ENDIF
IF pizza_audio_speech = 11
	LOAD_MISSION_AUDIO 1 PISS_11
	RETURN
ENDIF
IF pizza_audio_speech = 12
	LOAD_MISSION_AUDIO 1 PISS_12
	RETURN
ENDIF
IF pizza_audio_speech = 13
	LOAD_MISSION_AUDIO 1 PISS_13
	RETURN
ENDIF
IF pizza_audio_speech = 14
	LOAD_MISSION_AUDIO 1 PISS_14
	RETURN
ENDIF
IF pizza_audio_speech = 15
	LOAD_MISSION_AUDIO 1 PISS_15
	RETURN
ENDIF
IF pizza_audio_speech = 16
	LOAD_MISSION_AUDIO 1 PISS_16
	RETURN
ENDIF
IF pizza_audio_speech = 17
	LOAD_MISSION_AUDIO 1 PISS_17
	RETURN
ENDIF
IF pizza_audio_speech = 18
	LOAD_MISSION_AUDIO 1 PISS_18
	RETURN
ENDIF
IF pizza_audio_speech = 19
	LOAD_MISSION_AUDIO 1 PISS_19
	RETURN
ENDIF
RETURN

pizza_audio_print:
IF pizza_audio_speech = 1
	PRINT_NOW PIZ1_13 4000 1//Get these delivered nice and hot.
	RETURN
ENDIF
IF pizza_audio_speech = 2
	PRINT_NOW PIZ1_14 4000 1//Pal, pizza's for you.
	RETURN
ENDIF
IF pizza_audio_speech = 3
	PRINT_NOW PIZ1_15 4000 1//Hey, come on Mister, deliver these quick.
	RETURN
ENDIF
IF pizza_audio_speech = 4
	PRINT_NOW PIZ1_16 4000 1//What are you waiting around for Mister?  You got pizza's to deliver.
	RETURN
ENDIF
IF pizza_audio_speech = 5
	PRINT_NOW PIZ1_17 4000 1//I know you didn't want to be a pizza boy, well I don't give a damn.
	RETURN
ENDIF
IF pizza_audio_speech = 6
	PRINT_NOW PIZ1_18 4000 1//Deliver these.
	RETURN
ENDIF
IF pizza_audio_speech = 7
	PRINT_NOW PIZ1_19 4000 1//These need delivering.
	RETURN
ENDIF
IF pizza_audio_speech = 8
	PRINT_NOW PIZ1_20 4000 1//Come on Mister, deliver these things or you're sacked.
	RETURN
ENDIF
IF pizza_audio_speech = 9
	PRINT_NOW PIZ1_21 4000 1//We got people waiting pal.
	RETURN
ENDIF
IF pizza_audio_speech = 10
	PRINT_NOW PIZ1_22 4000 1//What are you waiting around for?  These need delivering!
	RETURN
ENDIF
IF pizza_audio_speech = 11
	PRINT_NOW PIZ1_23 4000 1//Deliver the damn food Mister.
	RETURN
ENDIF
IF pizza_audio_speech = 12
	PRINT_NOW PIZ1_24 4000 1//These need delivering pal.
	RETURN
ENDIF
IF pizza_audio_speech = 13
	PRINT_NOW PIZ1_25 4000 1//Man, can you take these?
	RETURN
ENDIF
IF pizza_audio_speech = 14
	PRINT_NOW PIZ1_26 4000 1//Mister, deliver these pronto, avamos amigo.
	RETURN
ENDIF
IF pizza_audio_speech = 15
	PRINT_NOW PIZ1_27 4000 1//Come on, we're in a rush, deliver these.
	RETURN
ENDIF
IF pizza_audio_speech = 16
	PRINT_NOW PIZ1_28 4000 1//You again?  well deliver these quick pal.
	RETURN
ENDIF
IF pizza_audio_speech = 17
	PRINT_NOW PIZ1_29 4000 1//No wasting time this time pal.
	RETURN
ENDIF
IF pizza_audio_speech = 18
	PRINT_NOW PIZ1_30 4000 1//Come on you lazy bastard, deliver this crap on time.
	RETURN
ENDIF
IF pizza_audio_speech = 19
	PRINT_NOW PIZ1_31 4000 1//You'll never get a promotion unless you move faster this time.
	RETURN
ENDIF
RETURN

pizza_audio_clear:
CLEAR_MISSION_AUDIO 1
IF pizza_audio_speech = 1
	CLEAR_THIS_PRINT PIZ1_13
	RETURN
ENDIF
IF pizza_audio_speech = 2
	CLEAR_THIS_PRINT PIZ1_14
	RETURN
ENDIF
IF pizza_audio_speech = 3
	CLEAR_THIS_PRINT PIZ1_15
	RETURN
ENDIF
IF pizza_audio_speech = 4
	CLEAR_THIS_PRINT PIZ1_16
	RETURN
ENDIF
IF pizza_audio_speech = 5
	CLEAR_THIS_PRINT PIZ1_17
	RETURN
ENDIF
IF pizza_audio_speech = 6
	CLEAR_THIS_PRINT PIZ1_18
	RETURN
ENDIF
IF pizza_audio_speech = 7
	CLEAR_THIS_PRINT PIZ1_19
	RETURN
ENDIF
IF pizza_audio_speech = 8
	CLEAR_THIS_PRINT PIZ1_20
	RETURN
ENDIF
IF pizza_audio_speech = 9
	CLEAR_THIS_PRINT PIZ1_21
	RETURN
ENDIF
IF pizza_audio_speech = 10
	CLEAR_THIS_PRINT PIZ1_22
	RETURN
ENDIF
IF pizza_audio_speech = 11
	CLEAR_THIS_PRINT PIZ1_23
	RETURN
ENDIF
IF pizza_audio_speech = 12
	CLEAR_THIS_PRINT PIZ1_24
	RETURN
ENDIF
IF pizza_audio_speech = 13
	CLEAR_THIS_PRINT PIZ1_25
	RETURN
ENDIF
IF pizza_audio_speech = 14
	CLEAR_THIS_PRINT PIZ1_26
	RETURN
ENDIF
IF pizza_audio_speech = 15
	CLEAR_THIS_PRINT PIZ1_27
	RETURN
ENDIF
IF pizza_audio_speech = 16
	CLEAR_THIS_PRINT PIZ1_28
	RETURN
ENDIF
IF pizza_audio_speech = 17
	CLEAR_THIS_PRINT PIZ1_29
	RETURN
ENDIF
IF pizza_audio_speech = 18
	CLEAR_THIS_PRINT PIZ1_30
	RETURN
ENDIF
IF pizza_audio_speech = 19
	CLEAR_THIS_PRINT PIZ1_31
	RETURN
ENDIF
RETURN
// SCFIX: END

}



