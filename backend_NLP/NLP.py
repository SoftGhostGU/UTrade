from flask import Flask, request, jsonify
from flask_cors import CORS
import spacy
import hanlp

app = Flask(__name__)
CORS(app)  # 允许所有域的跨域请求

# 全局加载模型
nlp_EN = spacy.load("en_core_web_sm")
nlp_ZH = spacy.load("zh_core_web_md")


@app.route('/')
def home():
    return "Welcome to the NER API!"


@app.route('/ner_EN', methods=['POST'])
def ner_EN():
    print("1. EN model")
    data = request.get_json()
    text = data.get('text', '')

    if not text:
        return jsonify({'error': 'No text provided'}), 400

    doc = nlp_EN(text)
    entities = [{'text': ent.text, 'label': ent.label_} for ent in doc.ents]
    return jsonify(entities)


@app.route('/ner_ZH', methods=['POST'])
def ner_ZH():
    data = request.get_json()
    text = data.get('text', '')

    HanLP = hanlp.load('CLOSE_TOK_POS_NER_SRL_DEP_SDP_CON_ELECTRA_SMALL_ZH')
    # HanLP('我现在需要参加数学建模大赛，我想要找一个编程手', tasks='srl').pretty_print()
    results = HanLP(text, tasks='srl').to_dict()['srl']

    # 筛选出ARG1标签的结果
    arg1_results = []
    for sentence in results:
        for result in sentence:
            if result[1] == 'ARG1':
                arg1_results.append(result)

    # 打印原文
    print(f"text: {text}")
    # 打印ARG1标签的结果
    print("sort: ", end='')
    for arg1_result in arg1_results:
        print(arg1_result[0], end=', ')
    return arg1_results #jsonify(arg1_result[0])


if __name__ == '__main__':
    app.run(port=8080, debug=True)