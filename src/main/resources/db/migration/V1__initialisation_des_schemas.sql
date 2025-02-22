CREATE TABLE "todos" (
    "todo_id" text NOT NULL,
    "title" text NOT NULL,
    "description" text,
    CONSTRAINT "todos_pkey" PRIMARY KEY ("todo_id")
);