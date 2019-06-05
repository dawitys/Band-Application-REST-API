

INSERT INTO `users` (`id`, `password`, `username`) 
		VALUES
(1, 'dawit', 'dawit'),
		
(2, 'dani', 'dani');



INSERT INTO `musicians` (`id`, `full_name`, `skill`, `user_id`)	
	VALUES
(7, 'Dawit Yonas', 'VOCALIST', 1),

	(8, 'Daniel Geremew', 'BASSIST', 2);



INSERT INTO `bands` (`id`, `contact_info`, `created_at`, `genre`, `band_name`, `leader_id`) 
	VALUES
(1, 'www.facebook.com/QuneaBand', '2019-06-05 11:08:28', 'Jazz', 'Qunea Band', 7);



INSERT INTO `bands_members` (`band_id`, `members_id`) 
			VALUES
(1, 7),
				(1, 8);



INSERT INTO `events` (`id`, `created_at`, `event_place`, `event_time`, `geo_location`, `band_id`) 
	VALUES
(1, '2019-06-05 14:20:22', 'Bole', '2019-07-19 07:30:00', '13.08,-42.51', 1);



INSERT INTO `schedules` (`id`, `created_at`, `geo_location`, `schedule_place`, `schedule_time`, `schedule_type`, `band_id`) 
	VALUES
(1, '2019-06-05 14:02:38', '15.0588,-45.51.', 'MKC', '2019-07-19 13:30:00', NULL, 1);

 
INSERT INTO `reviews` (`id`, `review_content`, `created_at`, `review_value`, `band_id`, `user_id`) 
	VALUES
(1, 'Very Classic Band', '2019-06-05 14:25:17', '4', 1, 1);

