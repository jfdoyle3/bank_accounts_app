CREATE TABLE IF NOT EXISTS ACCOUNTS(
    id          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    name        TEXT                              NOT NULL,
    savings     TEXT    UNIQUE,
    checking    TEXT    UNIQUE
    );