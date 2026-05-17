-- 초기화
DROP SCHEMA IF EXISTS discodeit CASCADE;
CREATE SCHEMA discodeit;
SET search_path TO discodeit;
COMMIT;

CREATE TABLE binary_contents
(
    id UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    content_type VARCHAR(100) NOT NULL,
    size BIGINT NOT NULL,
    bytes BYTEA NOT NULL
);

CREATE TABLE users
(
    id UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(60) NOT NULL,
    profile_id UUID,

    CONSTRAINT fk_users_profile FOREIGN KEY (profile_id) REFERENCES binary_contents (id) ON DELETE SET NULL,
    CONSTRAINT uk_users_profile UNIQUE (profile_id)
);

CREATE TABLE user_statuses
(
    id UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE,
    user_id UUID NOT NULL,
    last_active_at TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT fk_user_statuses_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT uk_user_statuses_user UNIQUE (user_id)
);

CREATE TABLE channels
(
    id UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE,
    name VARCHAR(100),
    description VARCHAR(500),
    type VARCHAR(10) NOT NULL
);

CREATE TABLE read_statuses
(
    id UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE,
    user_id UUID NOT NULL,
    channel_id UUID NOT NULL,
    last_read_at TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT fk_read_statuses_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_read_statuses_channel FOREIGN KEY (channel_id) REFERENCES channels (id) ON DELETE CASCADE
);

CREATE TABLE messages
(
    id UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE,
    content TEXT,
    author_id UUID NOT NULL,
    channel_id UUID NOT NULL,

    CONSTRAINT fk_messages_author FOREIGN KEY (author_id) REFERENCES users (id) ON DELETE SET NULL,
    CONSTRAINT fk_messages_channel FOREIGN KEY (channel_id) REFERENCES channels (id) ON DELETE CASCADE
);

CREATE TABLE message_attachments
(
    attachment_id UUID REFERENCES binary_contents (id) ON DELETE CASCADE,
    message_id UUID REFERENCES messages (id) ON DELETE CASCADE,

    PRIMARY KEY (attachment_id, message_id)
);

COMMIT;
