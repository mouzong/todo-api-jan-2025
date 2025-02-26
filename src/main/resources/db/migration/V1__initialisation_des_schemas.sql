CREATE TABLE "todos" (
    "todo_id" UUID NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "description" VARCHAR(255),
    CONSTRAINT "todos_pkey" PRIMARY KEY ("todo_id")
);