CREATE TABLE todos
(
    todo_id     UUID NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_todos PRIMARY KEY (todo_id)
);