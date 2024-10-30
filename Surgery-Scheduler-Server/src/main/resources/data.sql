-- Insert Addresses
INSERT INTO address (id, city, house_number, postal_code, street) VALUES
                                                                      (1, 'St. John''s', 10, 'A1A 1A1', 'Water Street'),
                                                                      (2, 'St. John''s', 20, 'A1B 2B2', 'Duckworth Street'),
                                                                      (3, 'St. John''s', 30, 'A1C 3C3', 'George Street');

-- Insert Doctors
INSERT INTO doctor (id, name) VALUES
                                  (1, 'Dr. Zachary Ropson'),
                                  (2, 'Dr. Garrett Smith'),
                                  (3, 'Dr. Rodney Stead');

-- Insert Hospitals
INSERT INTO hospital (id, name, address_id) VALUES
                                                (1, 'Health Sciences Centre', 1),
                                                (2, 'St. Clare''s Mercy Hospital', 2),
                                                (3, 'MUN Medical School', 3);

-- Insert Patients
INSERT INTO patient (id, mcp_number, name, address_id) VALUES
                                                           (1, '123456', 'Alice Johnson', 1),
                                                           (2, '234567', 'Bob Williams', 2),
                                                           (3, '345678', 'Charlie Davis', 3);

-- Insert Surgeries
INSERT INTO surgery (id, duration_of_surgery, time_end, time_start, type_of_surgery, doctor_doing_surgery_id, hospital_id, patient_id) VALUES
                                                                                                                                           (1, 120, '2024-11-01 14:00:00', '2024-11-01 12:00:00', 0, 1, 1, 1),
                                                                                                                                           (2, 90, '2024-11-02 15:30:00', '2024-11-02 14:00:00', 1, 2, 2, 2),
                                                                                                                                           (3, 60, '2024-11-03 16:00:00', '2024-11-03 15:00:00', 2, 3, 3, 3);


