/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package ai.djl.mxnet.zoo.cv.poseestimation;

import ai.djl.mxnet.zoo.BaseModelLoader;
import ai.djl.mxnet.zoo.ModelZoo;
import java.awt.image.BufferedImage;
import software.amazon.ai.modality.cv.Joints;
import software.amazon.ai.repository.Anchor;
import software.amazon.ai.repository.MRL;
import software.amazon.ai.repository.MRL.Model.CV;
import software.amazon.ai.repository.Repository;
import software.amazon.ai.translate.Translator;

public class SimplePoseModelLoader extends BaseModelLoader<BufferedImage, Joints> {

    private static final Anchor BASE_ANCHOR = CV.POSE_ESTIMATION;
    private static final String GROUP_ID = ModelZoo.GROUP_ID;
    private static final String ARTIFACT_ID = "simple_pose";
    private static final String VERSION = "0.0.1";

    public SimplePoseModelLoader(Repository repository) {
        super(repository, new MRL(BASE_ANCHOR, GROUP_ID, ARTIFACT_ID), VERSION);
    }

    @Override
    public Translator<BufferedImage, Joints> getTranslator() {
        return new SimplePoseTranslator.Builder()
                .optResize(256, 192)
                .optNormalize(
                        new float[] {0.485f, 0.456f, 0.406f}, new float[] {0.229f, 0.224f, 0.225f})
                .build();
    }
}