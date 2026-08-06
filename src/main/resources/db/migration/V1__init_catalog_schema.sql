-- Таблица образовательных программ
CREATE TABLE programs (
                          id UUID PRIMARY KEY,
                          code VARCHAR(50) UNIQUE NOT NULL,
                          title VARCHAR(255) NOT NULL,
                          description TEXT
);

-- Таблица предметов
CREATE TABLE subjects (
                          id UUID PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          description TEXT
);

-- Связь программ и предметов (многие ко многим)
CREATE TABLE program_subjects (
                                  program_id UUID REFERENCES programs(id) ON DELETE CASCADE,
                                  subject_id UUID REFERENCES subjects(id) ON DELETE CASCADE,
                                  subject_type VARCHAR(50) NOT NULL, -- 'MANDATORY' или 'SPECIALIZED'
                                  PRIMARY KEY (program_id, subject_id)
);

-- Таблица тем внутри предмета
CREATE TABLE topics (
                        id UUID PRIMARY KEY,
                        subject_id UUID NOT NULL REFERENCES subjects(id) ON DELETE CASCADE,
                        title VARCHAR(255) NOT NULL,
                        order_index INT DEFAULT 0
);

-- Таблица вопросов
CREATE TABLE questions (
                           id UUID PRIMARY KEY,
                           topic_id UUID NOT NULL REFERENCES topics(id) ON DELETE CASCADE,
                           text TEXT NOT NULL,
                           explanation TEXT
);

-- Таблица вариантов ответов
CREATE TABLE answers (
                         id UUID PRIMARY KEY,
                         question_id UUID NOT NULL REFERENCES questions(id) ON DELETE CASCADE,
                         text TEXT NOT NULL,
                         is_correct BOOLEAN NOT NULL DEFAULT FALSE
);