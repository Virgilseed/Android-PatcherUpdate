LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := updateJni
LOCAL_SRC_FILES := 	com_aiju_updatejni_UpdateJniUtils.c		\
					bzlib.c 		\
					blocksort.c 		\
                   	compress.c 		\
                   	crctable.c 		\
                   	decompress.c 		\
                   	huffman.c 		\
                   	randtable.c 		\
                   	bzip2.c 		\

LOCAL_LDLIBS := -llog

include $(BUILD_SHARED_LIBRARY)
